import Model.Store;
import Model.User;

import java.util.List;

public class CarRentalSystem {
    List<User> users;
    List<Store> stores;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
