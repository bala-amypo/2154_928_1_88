@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking for a facility and user
    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(@PathVariable Long facilityId, @PathVariable Long userId) {
        return bookingService.createBooking(facilityId, userId);
    }

    // Cancel booking
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    // Get booking by id
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }
}
