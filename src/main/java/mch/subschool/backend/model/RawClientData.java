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

@Data
public class RawClientData {

    @CsvBindByName()
    private String client_id;
    @CsvBindByName()
    private String gender; //Ж or М
    @CsvBindByName()
    @CsvNumber("#0")
    private int birth_date;
    @CsvBindByName()
    @CsvDate("yyyy-MM-dd")
    private Date create_date;//2020-01-29
    @CsvBindByName()
    private String nonresident_flag; //R or N
    @CsvBindByName()
    private boolean businessman_flag; //0 or 1?
    @CsvBindByName()
    private String city;
    @Nullable
    @CsvBindByName()
    private String term;//всё пустое
    @CsvBindByName()
    @CsvNumber("#0.0")
    private long contract_sum;//пример - 25005.0
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
    private long purchase_sum;
    @CsvBindByName()
    @CsvNumber("#0")
    private int purchase_count;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private long current_balance_avg_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private long current_balance_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private long current_debit_turn_sum;
    @CsvBindByName()
    @CsvNumber("#0.0")
    private long current_credit_turn_sum;
    @CsvBindByName()
    private String card_type;//dc or cc

    public RawClientData() {
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getNonresident_flag() {
        return nonresident_flag;
    }

    public void setNonresident_flag(String nonresident_flag) {
        this.nonresident_flag = nonresident_flag;
    }

    public int getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(int birth_date) {
        this.birth_date = birth_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public boolean getBusinessman_flag() {
        return businessman_flag;
    }

    public void setBusinessman_flag(boolean businessman_flag) {
        this.businessman_flag = businessman_flag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Nullable
    public String getTerm() {
        return term;
    }

    public void setTerm(@Nullable String term) {
        this.term = term;
    }

    public long getContract_sum() {
        return contract_sum;
    }

    public void setContract_sum(long contract_sum) {
        this.contract_sum = contract_sum;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    @Nullable
    public String getCard_type_name() {
        return card_type_name;
    }

    public void setCard_type_name(@Nullable String card_type_name) {
        this.card_type_name = card_type_name;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getFact_close_date() {
        return fact_close_date;
    }

    public void setFact_close_date(int fact_close_date) {
        this.fact_close_date = fact_close_date;
    }

    public long getPurchase_sum() {
        return purchase_sum;
    }

    public void setPurchase_sum(long purchase_sum) {
        this.purchase_sum = purchase_sum;
    }

    public int getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(int purchase_count) {
        this.purchase_count = purchase_count;
    }

    public long getCurrent_balance_avg_sum() {
        return current_balance_avg_sum;
    }

    public void setCurrent_balance_avg_sum(long current_balance_avg_sum) {
        this.current_balance_avg_sum = current_balance_avg_sum;
    }

    public long getCurrent_balance_sum() {
        return current_balance_sum;
    }

    public void setCurrent_balance_sum(long current_balance_sum) {
        this.current_balance_sum = current_balance_sum;
    }

    public long getCurrent_debit_turn_sum() {
        return current_debit_turn_sum;
    }

    public void setCurrent_debit_turn_sum(long current_debit_turn_sum) {
        this.current_debit_turn_sum = current_debit_turn_sum;
    }

    public long getCurrent_credit_turn_sum() {
        return current_credit_turn_sum;
    }

    public void setCurrent_credit_turn_sum(long current_credit_turn_sum) {
        this.current_credit_turn_sum = current_credit_turn_sum;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }
}
