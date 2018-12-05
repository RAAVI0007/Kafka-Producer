package com.rdsols.kafka.springbootkafkaexampleproducer.resource;


import com.rdsols.kafka.springbootkafkaexampleproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate ;

    @Value( "${KafkaTopic}" )
    private String kafkaTopic ;

    private static final String TOPIC = "SpringKafka";


    @RequestMapping("/publish/{name}")
    public  String postToKafakTopic(@PathVariable("name") final  String name) {

      System.out.println("kafkaTopic>>>>>" +kafkaTopic);
      //kafkaTemplate.send(kafkaTopic, message) ;
        kafkaTemplate.send(kafkaTopic,new User(name, "Hyderabad")) ;

      return "Message Posted successfully" ;

    }




}
