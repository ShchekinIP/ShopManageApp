package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shipment")
public class ShipmentEntity {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @Column(name = "id_shipment", columnDefinition = "nextval('hibernate_sequence')")
    private int idShipment;
    @Column(name = "name_sipment")
    private String nameShipment;
    @Column(name = "type_shipment")
    private String typeShipment;
    @Column(name = "adress_shipment")
    private String adressShipment;
    @Column(name = "date_shipment")
    private String dateShipment;
    @Column(name = "product_count")
    private int productCount;

    @OneToMany(mappedBy = "shipmentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutlayEntity> outlayEntityList;

    public ShipmentEntity() {
    }

    public ShipmentEntity(String nameShipment, String typeShipment, String adressShipment, String dateShipment, int productCount) {
        this.nameShipment = nameShipment;
        this.typeShipment = typeShipment;
        this.adressShipment = adressShipment;
        this.dateShipment = dateShipment;
        this.productCount = productCount;
        outlayEntityList = new ArrayList<>();
    }

    public ShipmentEntity( int id, String nameShipment, String typeShipment, String adressShipment, String dateShipment, int productCount) {
        this.idShipment = id;
        this.nameShipment = nameShipment;
        this.typeShipment = typeShipment;
        this.adressShipment = adressShipment;
        this.dateShipment = dateShipment;
        this.productCount = productCount;
        outlayEntityList = new ArrayList<>();
    }

    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }

    public String getNameShipment() {
        return nameShipment;
    }

    public void setNameShipment(String nameSipment) {
        this.nameShipment = nameSipment;
    }

    public String getTypeShipment() {
        return typeShipment;
    }

    public void setTypeShipment(String typeShipment) {
        this.typeShipment = typeShipment;
    }

    public String getAdressShipment() {
        return adressShipment;
    }

    public void setAdressShipment(String adressShipment) {
        this.adressShipment = adressShipment;
    }

    public String getDateShipment() {
        return dateShipment;
    }

    public void setDateShipment(String dateShipment) {
        this.dateShipment = dateShipment;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public List<OutlayEntity> getOutlayEntityList() {
        return outlayEntityList;
    }

    public void setOutlayEntityList(List<OutlayEntity> outlayEntityList) {
        this.outlayEntityList = outlayEntityList;
    }

    public void addOutlay(OutlayEntity outlayEntity){outlayEntityList.add(outlayEntity);}
    public void removeOutlay(OutlayEntity outlayEntity){outlayEntityList.remove(outlayEntity);}


}
