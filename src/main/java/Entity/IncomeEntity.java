package Entity;

import javax.persistence.*;

@Entity
@Table(name = "income")
public class IncomeEntity {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @Column(name = "id_income", columnDefinition = "nextval('hibernate_sequence')")
    private int idIncome;
    @Column(name = "type_income")
    private String typeIncome;
    @Column(name = "date_income")
    private String dateIncome;
    @Column(name = "sum_income")
    private int sumIncome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
    private ShopEntity shopEntity;

    public IncomeEntity() {
    }

    public IncomeEntity(String typeIncome, String dateIncome, int sumIncome) {
        this.typeIncome = typeIncome;
        this.dateIncome = dateIncome;
        this.sumIncome = sumIncome;
    }

    public IncomeEntity(int id, String typeIncome, String dateIncome, int sumIncome) {
        this.idIncome = id;
        this.typeIncome = typeIncome;
        this.dateIncome = dateIncome;
        this.sumIncome = sumIncome;
    }

    public IncomeEntity(int idIncome, String typeIncome, String dateIncome, int sumIncome, ShopEntity shopEntity) {
        this.idIncome = idIncome;
        this.typeIncome = typeIncome;
        this.dateIncome = dateIncome;
        this.sumIncome = sumIncome;
        this.shopEntity = shopEntity;
    }

    public int getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(int idIncome) {
        this.idIncome = idIncome;
    }

    public String getTypeIncome() {
        return typeIncome;
    }

    public void setTypeIncome(String typeIncome) {
        this.typeIncome = typeIncome;
    }

    public String getDateIncome() {
        return dateIncome;
    }

    public void setDateIncome(String dateIncome) {
        this.dateIncome = dateIncome;
    }

    public int getSumIncome() {
        return sumIncome;
    }

    public void setSumIncome(int sumIncome) {
        this.sumIncome = sumIncome;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }

    @Override
    public String toString() {
        return "IncomeEntity{" +
                "idIncome=" + idIncome +
                ", typeIncome='" + typeIncome + '\'' +
                ", dateIncome='" + dateIncome + '\'' +
                ", sumIncome=" + sumIncome +
                ", shopEntity=" + shopEntity +
                '}';
    }
}
