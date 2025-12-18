@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService unitService;

    @Autowired
    public ApartmentUnitController(ApartmentUnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public List<ApartmentUnit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @PostMapping
    public ApartmentUnit addUnit(@RequestBody ApartmentUnit unit) {
        return unitService.addUnit(unit);
    }

    // NEW: Assign unit to a user
    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignUnit(@PathVariable Long userId, @RequestBody ApartmentUnit unit) {
        return unitService.assignUnitToUser(userId, unit);
    }

    // NEW: Get all units assigned to a user
    @GetMapping("/user/{userId}")
    public List<ApartmentUnit> getUnitsByUser(@PathVariable Long userId) {
        return unitService.getUnitsByUser(userId);
    }
}
