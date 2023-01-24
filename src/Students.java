
public class Students {

    public  Students() {}

    public Students(int ID, String fullName,int age, String gender, String address, String mobile, int stage) {
        this.ID = ID;
        this.fullName = fullName;
        this.gender = gender;
        this.mobile = mobile;
        this.address = address;
        this.stage = stage;
        this.age = age;
    }

    private int ID;
    private String fullName;
    private int age;
    private String gender;
    private String address;
    private String mobile;
    private int stage;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public Students setFullName(String fullName) {
        this.fullName = fullName;
        return null;
    }

    public int getAge() {
        return age;
    }

    public Students setAge(int age) {
        this.age = age;
        return null;
    }

    public String getGender() {
        return gender;
    }

    public Students setGender(String gender) {
        this.gender = gender;
        return null;
    }

    public String getAddress() {
        return address;
    }

    public Students setAddress(String address) {
        this.address = address;
        return null;
    }

    public String getMobile() {
        return mobile;
    }

    public Students setMobile(String mobile) {
        this.mobile = mobile;
        return null;
    }

    public int getStage() {
        return stage;
    }

    public Students setStage(int stage) {
        this.stage = stage;
        return null;
    }

    @Override
    public String toString() {
        return "Students{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", stage=" + stage +
                '}';
    }
}
