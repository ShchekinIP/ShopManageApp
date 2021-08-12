package Entity;

import javax.persistence.*;

@Entity
@Table(name = "outlay")
public class OutlayEntity {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @Column(name = "id_outlay", columnDefinition = "nextval('hibernate_sequence')")
    private int idOutlay;
    @Column(name = "sum_outlay")
    private int sumOutlay;
    @Column(name = "date_outlay")
    private String dateOutlay;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
    private ShopEntity shopEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shipment")
    private ShipmentEntity shipmentEntity;

    public OutlayEntity() {
    }

    public OutlayEntity(int sumOutlay, String dateOutlay, ShopEntity shopEntity, ShipmentEntity shipmentEntity) {
        this.sumOutlay = sumOutlay;
        this.dateOutlay = dateOutlay;
        this.shopEntity = shopEntity;
        this.shipmentEntity = shipmentEntity;
    }

    public OutlayEntity(int idOutlay, int sumOutlay, String dateOutlay, ShopEntity shopEntity, ShipmentEntity shipmentEntity) {
        this.idOutlay = idOutlay;
        this.sumOutlay = sumOutlay;
        this.dateOutlay = dateOutlay;
        this.shopEntity = shopEntity;
        this.shipmentEntity = shipmentEntity;
    }

    public int getIdOutlay() {
        return idOutlay;
    }

    public void setIdOutlay(int idOutlay) {
        this.idOutlay = idOutlay;
    }

    public int getSumOutlay() {
        return sumOutlay;
    }

    public void setSumOutlay(int sumOutlay) {
        this.sumOutlay = sumOutlay;
    }

    public String getDateOutlay() {
        return dateOutlay;
    }

    public void setDateOutlay(String dateOutlay) {
        this.dateOutlay = dateOutlay;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }

    public ShipmentEntity getShipmentEntity() {
        return shipmentEntity;
    }

    public void setShipmentEntity(ShipmentEntity shipmentEntity) {
        this.shipmentEntity = shipmentEntity;
    }

    @Override
    public String toString() {
        return "OutlayEntity{" +
                "idOutlay=" + idOutlay +
                ", sumOutlay=" + sumOutlay +
                ", dateOutlay='" + dateOutlay + '\'' +
                ", shopEntity=" + shopEntity +
                ", shipmentEntity=" + shipmentEntity +
                '}';
    }
}
