package pl.coderslab.sender;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.coderslab.Service.UserService;
import pl.coderslab.model.User;
import pl.smsapi.BasicAuthClient;
import pl.smsapi.OAuthClient;
import pl.smsapi.api.SmsFactory;
import pl.smsapi.api.action.sms.SMSSend;
import pl.smsapi.api.response.MessageResponse;
import pl.smsapi.api.response.StatusResponse;
import pl.smsapi.exception.ClientException;
import pl.smsapi.exception.SmsapiException;

@Component
public class ScheduledTasks {

    @Autowired
    private UserService userService;

//    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 1000*60*60*24)
    public void reportCurrentTime() {

        for (User user : userService.findAll()) {

            if (user.getNextVisit().getDay() == new Date().getDay()) {


                // wyslij sms przypominajacy o zblizajacej sie wizycie
                // https://github.com/smsapi/smsapi-java-client
                //https://www.smsapi.pl/

                try {
//                    String passwordHash = "xvZThuS3i3GcUHGLJq64n4JAXKJKAjtjIaUp6nN0";
                    OAuthClient client = new OAuthClient("xvZThuS3i3GcUHGLJq64n4JAXKJKAjtjIaUp6nN0");

                    SmsFactory smsApi = new SmsFactory(client);
                    String phoneNumber = user.getPhnoneNumber();
                    SMSSend action = smsApi.actionSend()
                            .setText("przypominamy o jutrzejszej wizycie w gabinecie")
                            .setTo(phoneNumber);

                    StatusResponse result = action.execute();

                    for (MessageResponse status : result.getList() ) {
                        System.out.println(status.getNumber() + " " + status.getStatus());
                    }
                } catch (ClientException e) {
                    /**
                     * 101 Niepoprawne lub brak danych autoryzacji.
                     * 102 Nieprawidłowy login lub hasło
                     * 103 Brak punków dla tego użytkownika
                     * 105 Błędny adres IP
                     * 110 Usługa nie jest dostępna na danym koncie
                     * 1000 Akcja dostępna tylko dla użytkownika głównego
                     * 1001 Nieprawidłowa akcja
                     */
                    e.printStackTrace();
                } catch (SmsapiException e) {
                    e.printStackTrace();
                }
            }
        }

//        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
