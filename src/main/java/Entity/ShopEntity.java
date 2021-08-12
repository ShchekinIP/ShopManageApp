package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
public class ShopEntity {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @Column(name = "id_shop")
    private int idShop;
    @Column(name = "name_shop")
    private String nameShop;
    @Column(name = "adress_shop")
    private String adressShop;
    @Column(name = "type_shop")
    private String typeShop;
    @Column(name = "capital_shop")
    private int capitalShop;

    @OneToMany(mappedBy = "shopEntity", cascade = CascadeType.ALL)
    private List<IncomeEntity> incomeEntityList;
    @OneToMany(mappedBy = "shopEntity", cascade = CascadeType.ALL)
    private List<WorkerEntity> workerEntityList;
    @OneToMany(mappedBy = "shopEntity", cascade = CascadeType.ALL)
    private List<OutlayEntity> outlayEntityList;

    public ShopEntity(){};

    public ShopEntity(String nameShop, String adressShop, String typeShop, int capitalShop) {
        this.nameShop = nameShop;
        this.adressShop = adressShop;
        this.typeShop = typeShop;
        this.capitalShop = capitalShop;
        incomeEntityList = new ArrayList<>();
        workerEntityList = new ArrayList<>();
        outlayEntityList = new ArrayList<>();
    }

    public ShopEntity(int id, String nameShop, String adressShop, String typeShop, int capitalShop) {
        this.idShop = id;
        this.nameShop = nameShop;
        this.adressShop = adressShop;
        this.typeShop = typeShop;
        this.capitalShop = capitalShop;
        incomeEntityList = new ArrayList<>();
        workerEntityList = new ArrayList<>();
        outlayEntityList = new ArrayList<>();
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getAdressShop() {
        return adressShop;
    }

    public void setAdressShop(String adressShop) {
        this.adressShop = adressShop;
    }

    public String getTypeShop() {
        return typeShop;
    }

    public void setTypeShop(String typeShop) {
        this.typeShop = typeShop;
    }

    public int getCapitalShop() {
        return capitalShop;
    }

    public void setCapitalShop(int capitalShop) {
        this.capitalShop = capitalShop;
    }

    public List<IncomeEntity> getIncomeEntityList() {
        return incomeEntityList;
    }

    public void setIncomeEntityList(List<IncomeEntity> incomeEntityList) {
        this.incomeEntityList = incomeEntityList;
    }

    public List<WorkerEntity> getWorkerEntityList() {
        return workerEntityList;
    }

    public void setWorkerEntityList(List<WorkerEntity> workerEntityList) {
        this.workerEntityList = workerEntityList;
    }

    public List<OutlayEntity> getOutlayEntityList() {
        return outlayEntityList;
    }

    public void setOutlayEntityList(List<OutlayEntity> outlayEntityList) {
        this.outlayEntityList = outlayEntityList;
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "idShop=" + idShop +
                ", nameShop='" + nameShop + '\'' +
                ", adressShop='" + adressShop + '\'' +
                ", typeShop='" + typeShop + '\'' +
                ", capitalShop=" + capitalShop +
                ", incomeEntityList=" + incomeEntityList +
                ", workerEntityList=" + workerEntityList +
                ", outlayEntityList=" + outlayEntityList +
                '}';
    }

    public void addIncome(IncomeEntity incomeEntity){incomeEntityList.add(incomeEntity);}
    public void removeIncome(IncomeEntity incomeEntity){incomeEntityList.remove(incomeEntity);}

    public void addWorker(WorkerEntity workerEntity){workerEntityList.add(workerEntity);}
    public void removeWorker(WorkerEntity workerEntity){workerEntityList.remove(workerEntity);}

    public void addOutlay(OutlayEntity outlayEntity){outlayEntityList.add(outlayEntity); }
    public void removeOutlay(OutlayEntity outlayEntity){outlayEntityList.remove(outlayEntity);}



}
