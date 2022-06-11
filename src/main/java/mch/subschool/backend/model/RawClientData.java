package mch.subschool.backend.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * Формат данных из представленного заказчиком датапула
 */


public class RawClientData {

    @CsvBindByName()
    private String client_id;
    @CsvBindByName()
    private String gender; //Ж or М
    @CsvBindByName()
    private int birth_date;

    @CsvBindByName()
    @CsvDate("dd.MM.yyyy")
    private Date create_date;

    @CsvBindByName()
    private String nonresident_flag; //R or N
    @CsvBindByName()
    private int businessman_flag; //0 or 1?

    @CsvBindByName()
    private String city;

    @Nullable
    @CsvBindByName()
    private String term;//всё пустое

    @CsvBindByName()
    @CsvNumber("#0.0")
    private int contract_sum;//пример - 25005.0

    @CsvBindByName()
    private String product_category_name;

    @CsvBindByName()
    private String card_id;
    @CsvBindByName()
    @Nullable
    private String card_type_name;

    @CsvBindByName()
    @CsvNumber("#0.0")
    private int start_date; //2019.0
    @CsvBindByName()
    @CsvNumber("#0.0")
    private int fact_close_date; //2021.0

    @CsvBindByName()
    @CsvNumber("#0.0")
    private int purchase_sum;
    @CsvBindByName()
    @CsvNumber("#0")
    private int purchase_count;

    @CsvBindByName()
    @CsvNumber("#0.0")
    private double current_balance_avg_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private double current_balance_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private double current_debit_turn_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private double current_credit_turn_sum;

    @CsvBindByName()
    private String card_type;//dc or cc
}
