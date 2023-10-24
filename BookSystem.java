import java.util.Scanner;

public class BookSystem {
    private String nama;
    private String noTelp;
    private String alamat;
    private String email;
    private int[][] room = {{0, 83, 1000000}, {0, 90, 2500000}, {0, 100,300000}
    };



    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNama() {
        return nama;
    }
    public String getNoTelp() {
        return noTelp;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getEmail() {
        return email;
    }
    public int[][] getRoom() {

        return room;
    }


    public void init() {
        Scanner input = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI HOTEL RASY\n\n ");
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        setNama(nama);

        System.out.print("Masukkan no telp (+62): ");
        String noTelp = input.nextLine();
        setNoTelp(noTelp);

        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        setAlamat(alamat);

        System.out.print("Masukkan email: ");
        String email = input.nextLine();
        setEmail(email);

    }

    public void dispPerson() {
        System.out.println("Nama: " + getNama());
        System.out.println("No Telp: " + getNoTelp());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Email: " + getEmail());
    }


    public void bookRoom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Kamar yang tersedia: ");
        System.out.println("Kamar\tHarga");

        for (int i = 0; i < room.length; i++) {
            if (room[i][0] == 0) {
                System.out.println(room[i][1]  +   "\t\tRp " + room[i][2]  );
            }
        }

        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
        int noRoom = input.nextInt();


        boolean isValidRoom = false;
        for (int i = 0; i < room.length; i++) {
            if (room[i][1] == noRoom && room[i][0] == 0) {
                isValidRoom = true;
                break;
            }
        }

        if (isValidRoom) {
            System.out.println("Booking berhasil!");
            doPayment(noRoom);
        } else {
            System.out.println("Nomor kamar tidak tersedia .");

        }
    }


    public void doPayment(int noRoom) {
        for (int i = 0; i < room.length; i++) {
            if (room[i][1] == noRoom) {
                room[i][0] = 1;
                System.out.println("Pembayaran berhasil.");
                System.out.println("Nomor kamar : " + room [i][1]);

            }

        }
    }

    public static void main(String[] args) {
        BookSystem booking = new BookSystem();
        booking.init();
        booking.dispPerson();

        Scanner input = new Scanner(System.in);
        String answer;
        do {
            booking.bookRoom();
            System.out.print("Apakah ingin memesan lagi? (Y/T) ");
            answer = input.nextLine();
        } while (answer.equalsIgnoreCase("y"));

    }
}
