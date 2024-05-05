package org.example.Mock.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import org.example.Mock.Model.ClientInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Random;

@RestController
public class MainController {

    private final Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/api/info/clients/{clientCode}")
    public Object info(@PathVariable String clientCode)
    {
        try {
            BigInteger id = BigInteger.probablePrime(8, new Random());
            String clientName;
            String status;

            Faker faker = new Faker();
            clientName = faker.name().fullName();

            String[] statuses = {"ACTIVE", "PENDING", "INACTIVE"};
            Random rand = new Random();
            status = statuses[rand.nextInt(statuses.length)];

            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setClientCode(clientCode);
            clientInfo.setId(id);
            clientInfo.setClientName(clientName);
            clientInfo.setStatus(status);

            log.error("\n*********** ClientInfo **********\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientInfo));

            return clientInfo;

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
