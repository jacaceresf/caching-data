package py.com.jacaceres.cache.cachingdata.beans;

public class Customer {

    private String customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Customer(CustomerBuilder builder){
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.address =builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * Just a builder class.
     */
    public static class CustomerBuilder{
        private final String customerId;
        private final String name;
        private String phoneNumber;
        private String address;
        private String email;

        public CustomerBuilder(String name, String customerId){
            this.customerId = customerId;
            this.name = name;
        }

        public CustomerBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder address(String address){
            this.address = address;
            return this;
        }

        public CustomerBuilder email(String email){
            this.email = email;
            return this;
        }

        public Customer build(){
            Customer customer = new Customer(this);
            return customer;
        }
    }
}
