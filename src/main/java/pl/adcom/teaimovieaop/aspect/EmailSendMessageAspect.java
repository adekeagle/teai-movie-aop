package pl.adcom.teaimovieaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.adcom.teaimovieaop.model.Movie;
import pl.adcom.teaimovieaop.service.EmailServiceImpl;

@Aspect
@Component
public class EmailSendMessageAspect {

    @Value("${email.address.to}")
    private String mailAddres;

    private EmailServiceImpl emailService;
    private static final String SUBJECT = "Movie has been added to database";
    private static final String BODY = "Movie ";
    Logger logger = LoggerFactory.getLogger(EmailSendMessageAspect.class);

    @Autowired
    public EmailSendMessageAspect(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @After("@annotation(EmailAspect) && args(movie)")
    private void sendEmailAfterAddMovie(Movie movie){
        emailService.sendSimpleMessage(mailAddres,
                                        SUBJECT,
                                   "Movie: " + movie.getName().toString() + " year: " + movie.getYear() + " producer: " + movie.getProducer());
        logger.info("Mail został wysłany");
    }
}
