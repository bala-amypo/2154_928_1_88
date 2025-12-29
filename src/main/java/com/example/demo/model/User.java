import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;
}

@Data
@Entity
public class ApartmentUnit {
    @Id @GeneratedValue
    private Long id;
    private String unitNumber;
    private Integer floor;

    @OneToOne
    private User owner;
}

// Booking, Facility, BookingLog same pattern
