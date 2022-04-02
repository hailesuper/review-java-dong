import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account dong = new Account();
        dong.name = "Dong";
        Account hai = new Account();
        hai.name = "Hai";

        Group java = new Group();
        java.name = "Java";
        Group guitar = new Group();
        guitar.name = "Guitar";
        Group honda = new Group();
        honda.name = "Honda";

        //Object Dong co thuoc tinh group. Trong thuoc tinh group - la 1 mang moi co chua {java}

//        dong.groups = new Group[1];
        Group[] dongGroup = {java};
        dong.groups = dongGroup;

        hai.groups = new Group[] {honda, java};
        System.out.println(hai.groups.length);

        Group[] trungGian = new Group[] {hai.groups[0],hai.groups[1],guitar};
        hai.groups = trungGian;
        System.out.println(hai.groups.length);

        // Tao object luu tat ca account da tao: accounts
        // Tao object luu tat ca cac group da tao: groups
        Account[] accounts = new Account[] {dong,hai};
        Group[] groups = new Group[] {java,guitar,honda};

        // In thuoc tinh NAME cua phan tu thu 1 trong array accounts

        System.out.println(accounts[0].name);

        System.out.println("----- START -------");

        // IN ra NAME cua cac account cho nguoi dung xem
        // vong lap while, for, do while
        for (int i=0; i < accounts.length; i++) {
            System.out.println(accounts[i].name);
        }

        // Yêu cầu người dùng nhập vào NAME của account
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap name cua account di: ");
        String accountName = scanner.nextLine();


        // In ra GROUP NAME
        for (int i=0; i < groups.length; i++) {
            System.out.println(groups[i].name);
        }
        // Yêu cầu người dùng nhập vào tên của group
        System.out.println("Nhap vao ten group ");
        String groupName = scanner.nextLine();

        System.out.println(accountName + " " + groupName);

        dong.groups = new Group[] {java, honda};
        hai.groups = new Group[] {guitar};

        // Dựa vào account name và tên của group người dùng vừa chọn, hãy
        //thêm account vào group đó .

        // Tim object nhap vao
        int findAccountIndex = -1;
        for (int i=0; i < accounts.length; i++) {
            if (accounts[i].name.equals(accountName)) {
                findAccountIndex = i;
                break;
            }
        }

        System.out.println(findAccountIndex);

        int findGroupIndex = -1;
        for (int i=0; i < groups.length; i++) {
            if (groups[i].name.equals(groupName)) {
                findGroupIndex = i;
                break;
            }
        }
        System.out.println(findGroupIndex);

        Group[] groupTrungGian = new Group[accounts[findAccountIndex].groups.length + 1]; // {null, null, null}
        for (int i=0; i< accounts[findAccountIndex].groups.length; i++) {
            groupTrungGian[i] = accounts[findAccountIndex].groups[i]; // {java, honda, null}
        }

        groupTrungGian[groupTrungGian.length - 1] = groups[findGroupIndex];

        accounts[findAccountIndex].groups = groupTrungGian;

        System.out.println("Cac group trong account " + accounts[findAccountIndex].name + " sau khi them ");

        for (Group group : accounts[findAccountIndex].groups) {
            System.out.println(group.name);
        }
    }
}
