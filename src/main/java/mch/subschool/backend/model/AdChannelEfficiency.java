package mch.subschool.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class AdChannelEfficiency {

    @Id
    int id;

    String channelName;

    List<AdCompanyEfficiency> company;
}

