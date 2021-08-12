package Entity;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @Column(name = "id_worker", columnDefinition = "nextval('hibernate_sequence')")
    private int idWorker;
    @Column(name = "fio_worker")
    private String fioWorker;
    @Column(name = "employment_records")
    private String employmentRecords;
    @Column(name = "type_worker")
    private String typeWorker;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop")
    private ShopEntity shopEntity;


    public WorkerEntity() {
    }

    public WorkerEntity(String fioWorker, String employmentRecords, String typeWorker) {
        this.fioWorker = fioWorker;
        this.employmentRecords = employmentRecords;
        this.typeWorker = typeWorker;
    }

    public WorkerEntity(int idWorker, String fioWorker, String employmentRecords, String typeWorker, ShopEntity shopEntity) {
        this.idWorker = idWorker;
        this.fioWorker = fioWorker;
        this.employmentRecords = employmentRecords;
        this.typeWorker = typeWorker;
        this.shopEntity = shopEntity;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getFioWorker() {
        return fioWorker;
    }

    public void setFioWorker(String fioWorker) {
        this.fioWorker = fioWorker;
    }

    public String getEmploymentRecords() {
        return employmentRecords;
    }

    public void setEmploymentRecords(String employmentRecords) {
        this.employmentRecords = employmentRecords;
    }

    public String getTypeWorker() {
        return typeWorker;
    }

    public void setTypeWorker(String typeWorker) {
        this.typeWorker = typeWorker;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }

    @Override
    public String toString() {
        return "WorkerEntity{" +
                "idWorker=" + idWorker +
                ", fioWorker='" + fioWorker + '\'' +
                ", employmentRecords='" + employmentRecords + '\'' +
                ", typeWorker='" + typeWorker + '\'' +
                ", shopEntity=" + shopEntity +
                '}';
    }
}
