package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "series")
    private int series;

    @Column (name = "model")
    private String model;


//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(int series, String model) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public int setSeries(int series) {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return model + ' ' + series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (series != car.series) return false;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = model == null ? 0 : model.hashCode();
        result = result + series;
        return result;
    }
}
