package mch.subschool.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import mch.subschool.backend.common.Statistic;
import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * Формат данных из представленного заказчиком датапула
 */

@Data
public class RawClientData {

    private String client_id;
    private String gender; //Ж or М
    private int birth_date;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date create_date;

    private String nonresident_flag; //R or N
    private int businessman_flag; //0 or 1?

    private String city;

    @Nullable
    private String term;//всё пустое

    private double contract_sum;
    private String product_category_name;

    private String card_id;
    @Nullable
    private String card_type_name;

    @Nullable
    @JsonFormat(pattern="yyyy")
    private Date start_date; //2019.0
    @Nullable
    @JsonFormat(pattern="yyyy")
    private Date fact_close_date; //2021.0

    private double purchase_sum;
    private int purchase_count;

    private double current_balance_avg_sum;
    private double current_balance_sum;
    private double current_debit_turn_sum;
    private double current_credit_turn_sum;

    private String card_type;//dc or cc
}
