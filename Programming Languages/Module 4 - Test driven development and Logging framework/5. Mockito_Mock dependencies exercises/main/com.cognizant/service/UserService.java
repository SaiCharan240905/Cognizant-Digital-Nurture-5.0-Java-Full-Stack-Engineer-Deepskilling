@Service
public class UserService {

    private final UserRepository repository;

    public UserService(
            UserRepository repository) {

        this.repository = repository;
    }

    public User getUserById(Long id) {

        return repository
                .findById(id)
                .orElse(null);
    }
}