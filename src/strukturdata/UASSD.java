package strukturdata;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

record User(String username, String password) {}
public class UASSD {
    private static final String[] jadwalLapangan = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    
    private static final List<User> users = new ArrayList<>();

    private static void register(String username, String password) {
        users.add(new User(username, password));
        System.out.println("Registrasi berhasil!");
    }

    private static boolean login(String username, String password) {
        return users.stream().anyMatch(user -> user.username().equals(username) && user.password().equals(password));
    }
    
    record bookin( String Paket,String nama,String noHp,int kok,String waktuBooking,String formatterdDate,int total){}
    record khusus(String Paket,String nama,String noHp, String kegiatan,String waktuBooking,String formatterdDate,int total){}
    record verif( String Paket,String nama){}
    
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean inginMelakukanBooking = true;
            boolean huruf,angka;
            
            LinkedList<String> listkode = new LinkedList<>();
            LinkedList<bookin> daftaruser = new LinkedList<>();
            LinkedList<khusus> usekhusus = new LinkedList<>();
            LinkedList<verif> verifikasi = new LinkedList<>();
            
            String expectedUsername = "admin",
                   expectedPassword = "123";
                
            String loginUsername = "";
            String Nama = "",nohp = null ;
            String bookingan,kegiatan,waktuBooking,konfirmasi;
            String[] listKode;
            int jam,kok,harga,total,i;
            int jumlahBooking = 0;
            int a = 4;
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatterdDate = myDateObj.format(myFormatObj);

        while (inginMelakukanBooking) {
             
            System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("|\033[46m                                                GOR BANJALAN                                                            |");
            System.out.println("\033[46m├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\033[0m");
            System.out.println("\033[47m| List User                                                                                                              |");
            System.out.println("|\033[47m 1. Admin                                                                                                               |");
            System.out.println("|\033[47m 2. Customer                                                                                                            |");
            System.out.println("|\033[47m 3. Member                                                                                                              |");
            System.out.println("|\033[47m 4. Tentang kami & peraturan & bantuan                                                                                  |");
            System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
            
            try {
                System.out.print("Pilih (1-4): ");
                int choose = scanner.nextInt();

                if (choose < 1 || choose > 4) {
                    System.out.println("Pilihan tidak valid. Harap masukkan angka antara 1 dan 4.");
                    continue;
                }
            
            if (choose == 1) {
                
                // MENU ADMIN
                System.out.println("");
                boolean login = true;
                boolean bebas = true;
                while (bebas) {
                while (login) {
                    System.out.println("\033[46m┌────────────────────────────────────────────────────────────────┐\033[0m");
                    System.out.println("\033[47m|                      MENU ADMIN                        │");
                    System.out.println("\033[46m└────────────────────────────────────────────────────────────────┘\033[0m");                    
                    System.out.print("Masukkan Username: ");
                    String username = scanner.next();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.next();
                    
                    if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
                        
                        System.out.println("\033[32m┌────────────────────────────────────────────────────────────────┐\033[0m");
                        System.out.println("\033[32m│                     LOGIN BERHASIL                    │\033[0m");
                        System.out.println("\033[32m└────────────────────────────────────────────────────────────────┘\033[0m");                                   
                        login = false;
                    } else {
                        System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
                        System.out.println("\033[31m│                       LOGIN GAGAL                     │\033[0m");           
                        System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");

                    }if (!username.equals(expectedUsername)) {
                        System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
                        System.out.println("\033[31m│          USERNAME YANG ANDA MASUKKAN SALAH            │\033[0m");
                        System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");           
                        
                     }
                     if (!password.equals(expectedPassword)) {
                        System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
                        System.out.println("\033[31m│          PASSWORD YANG ANDA MASUKKAN SALAH            │\033[0m");
                        System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");           
            }
                    
                }
                System.out.println("");
                System.out.println("\033[46m┌────────────────────────────────────────────────────────────────┐");
                System.out.println("│                      MENU ADMIN                       │");
                System.out.println("\033[46m└────────────────────────────────────────────────────────────────┘\033[0m"
                        + "");                                 
                System.out.println("│ 1. Booking Masuk & Verifikasi                            │");
                System.out.println("│ 2. Booking terVerifikasi                                 │");
                System.out.println("│ 3. Kembali                                               │");
                System.out.println("\033[46m└────────────────────────────────────────────────────────────────┘\033[0m");
                System.out.print("Pilih (1-3): ");
                int pilih = scanner.nextInt();
                if (pilih == 1) { 
                    if(!daftaruser.isEmpty()){
                        System.out.println("\nList bookingan masuk");
                        System.out.println("");
                        System.out.println("\033[31m┌───────────────────────────────────────────────────────────────────────────────┐\033[0m");
                    for (bookin anggota : daftaruser) {
                        System.out.println("paket: " + anggota.Paket  + ", Nama: " + anggota.nama() + ", NoHP: " + anggota.noHp() + ", pada jam: " + anggota.waktuBooking  +", Waktu: "+ anggota.formatterdDate+", harga: "+anggota.total());
                    }
                    for (khusus use : usekhusus) {
                        System.out.print("paket: " + use.Paket + ", Nama: " + use.nama() + ", NoHP: " + use.noHp()+ ", kegiatan: " + use.kegiatan + ", pada jam: " + use.waktuBooking+", Waktu: "+ use.formatterdDate+", harga: "+use.total());
                    } System.out.println("\033[31m└──────────────────────────────────────────────────────────────────────────────────┘\033[0m"); 
                    System.out.println("");
                    
                    
                    System.out.println("verifikasi");
        scanner.nextLine();
        System.out.print("Masukan Paket: ");
        konfirmasi = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String acc = scanner.nextLine();

        // Check if the name exists in either daftaruser or usekhusus
        boolean isNameFound = false;
        for (bookin anggota : daftaruser) {
            if (anggota.nama().equals(acc)) {
                isNameFound = true;
                break;
            }
        }
        for (khusus use : usekhusus) {
            if (use.nama().equals(acc)) {
                isNameFound = true;
                break;
            }
        }

        if (isNameFound) {
            verifikasi.add(new verif(konfirmasi, acc));
            daftaruser.removeIf(anggota -> anggota.nama().equals(acc));
            usekhusus.removeIf(use -> use.nama().equals(acc));
           System.out.println("\033[32m┌────────────────────────────────────────────────────────────────┐\033[0m");
           System.out.println("\033[32m│                   VERIFIKASI BERHASIL                  │\033[0m");
           System.out.println("\033[32m└────────────────────────────────────────────────────────────────┘\033[0m"); 
        } else {
            System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
            System.out.println("\033[31m│          VERIFIKASI DATA TIDAK VALID            │\033[0m");
            System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");  

        }

    } else {
        System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
        System.out.println("\033[31m│               BELUM ADA BOOKINGAN MASUK               │\033[0m");
        System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");

    }
} else if (pilih == 2) {
    if (!verifikasi.isEmpty()) {
        for (verif go : verifikasi) {
            System.out.print("Nama: " + go.nama() + " , paket: " + go.Paket() + ", pada jam: " + listkode);
        }
    } else {
        System.out.println("\033[31m┌────────────────────────────────────────────────────────────────┐\033[0m");
        System.out.println("\033[31m│                  BELUM ADA VERIFIKASI                 │\033[0m");
        System.out.println("\033[31m└────────────────────────────────────────────────────────────────┘\033[0m");  
    }
                } else if(pilih == 3){
                    
                    break;
                }
                    }
                
            } else if (choose == 2) {
                
                // MENU CUSTOMER
            System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("|\033[46m                                       Selamat datang di GOR BANJALAN                                                   |");
            System.out.println("\033[46m├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\033[0m");
            System.out.println("\033[47m| 1. Booking GOR (Badminton)                                                                                             |");
            System.out.println("|\033[47m 2. Booking GOR (Kegiatan lain seperti pengajian,seminar,turnamen)                                                      |");
            System.out.println("|\033[47m 3. Kembali                                                                                                             |");
            System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
            System.out.print("Pilih(1-3): ");
                int pilihan = scanner.nextInt();
                switch (pilihan) {
                    
                    //REGULER
                    
                    case 1:
                        System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                        System.out.println("|\033[46m                                        Reguler/Badminton                                                                |");
                        System.out.println("\033[46m├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\033[0m");
                        System.out.println("\033[47m| 1. Paket Per Jam Rp30.000                                                                                               |");
                        System.out.println("|\033[47m 2. Paket Promo Rp50.000 (2 jam + 1 kok)                                                                                 |");
                        System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                        System.out.print("pilih (1-2): ");
                        int milih = scanner.nextInt();
                    if (milih == 1){
                        System.out.println("Anda memilih paket Reguler perjam. Silakan lakukan booking. Harga untuk 1 jam Rp30.000");
                        bookingan = "Reguler";
                        System.out.print("Ingin Membooking Berapa Jam? (masukan angka): ");
                        jam = scanner.nextInt();
                        
                        System.out.println("Waktu yang tersedia");
                        for (String waktu : jadwalLapangan) {
                        System.out.println(waktu + " ");
                         }
                        System.out.println("");
                        System.out.println("Masukkan waktu yang ingin Anda booking (hh:mm) (pisahkan dengan koma jika lebih dari satu): ");
                        System.out.println("contoh 09:00,10:00 (untuk waktu 09:00-09:59,10:00-10:59)");
                        System.out.println("masukan waktu: ");
                        waktuBooking = scanner.next();
                        listKode = waktuBooking.split(",");

                        for (i = 0; i < listKode.length; i++) {
                        listKode[i] = listKode[i].trim();
                        listkode.add(listKode[i]);
                        for (int j = 0; j < jadwalLapangan.length; j++) {
                            if (jadwalLapangan[j].equals(listKode[i])) {
                                jadwalLapangan[j] = "Booked";
                                    }
                                }
                            } 
                        int perjam = 30000;
                        System.out.print("Ingin membeli berapa Kok?, satu kok seharga Rp18.000 : ");
                        kok = scanner.nextInt();
                        int hargakok = 18000;
                        int kok1 = kok * hargakok;
                        harga = jam * perjam;
                        total = kok1 + harga;
                        System.out.println("");
                        System.out.println("Lakukan registrasi");
                        do{
                        System.out.print("Masukan Nama: ");
                        Nama = scanner.next();
                        huruf = Nama.matches("[a-zA-Z]+");
                        if (huruf) {
                         } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya huruf.");
                         }
                            } while (!huruf);
                        do{
                        System.out.print("Masukan no hp: ");
                        nohp = scanner.next();
                        angka = nohp.matches("[0-9]+");
                        if (angka) {
                        } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya angka.");
                         }
                        } while (!angka);
                        

                        
                        
                         System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                        System.out.println("\nTotal");
                        System.out.println("waktu        : " +waktuBooking );
                        System.out.println("Harga kok    : "+kok1);
                        System.out.println("Harga lapang : "+harga +" x "+jam+" jam");
                        System.out.println("Total Bayar  : "+ total );
                        System.out.println("terdata      : "+formatterdDate);
                        System.out.println("");
                       System.out.println("Bayar menggunakan BRI :093277367, BCA :3798759270820");
                       System.out.println("Bayar menggunakan Dana,Ovo no.0818044030");
                        System.out.println("");
                        System.out.println("Kirim Bukti transfer ke: 085122522156 untuk konfirmasi");  
                        System.out.println("Terimakasih telah membooking di GOR Banjalan...");
                        System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                        daftaruser.add(new bookin(bookingan,Nama,nohp,kok,waktuBooking,formatterdDate,total));
                
                        //Promo
                   }else if (milih == 2){
                        System.out.println("Anda memilih paket Promo. Seharga Rp50.000 (2 jam + 1 kok) Silakan lakukan booking.");
                        bookingan = "Promo";
                        int promo = 50000; 
                        kok = 1;
                        
                    System.out.println("Waktu yang tersedia");
                    System.out.println("Jadwal Lapangan:");
                for (String waktu : jadwalLapangan) {
                    System.out.println(waktu + " ");
                     }
                
                      System.out.println("Masukkan waktu yang ingin Anda booking (hh:mm) (pisahkan dengan koma jika lebih dari satu): ");
                        System.out.println("contoh 09:00,10:00 (untuk waktu 09:00-09:59,10:00-10:59)");
                        System.out.println("masukan 2 waktu: ");
                      waktuBooking = scanner.next();
                      listKode = waktuBooking.split(",");
                for (i = 0; i < listKode.length; i++) {
                    listKode[i] = listKode[i].trim();
                    listkode.add(listKode[i]);
                    for (int j = 0; j < jadwalLapangan.length; j++) {
                        if (jadwalLapangan[j].equals(listKode[i])) {
                            jadwalLapangan[j] = "Booked";
                                   }
                             }
                         } 
                        System.out.println("");
                     System.out.println("lakukan Registrasi");
                     do{
                        System.out.print("Masukan Nama: ");
                        Nama = scanner.next();
                        huruf = Nama.matches("[a-zA-Z]+");
                        if (huruf) {
                         } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya huruf.");
                         }
                            } while (!huruf);
                     do{
                        System.out.print("Masukan no hp: ");
                        nohp = scanner.next();
                        angka = nohp.matches("[0-9]+");
                        if (angka) {
                        } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya angka.");
                         }
                        } while (!angka);
                         total=50000;
                         System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                        System.out.println("Total");
                        System.out.println("waktu pukul  : " +waktuBooking );
                        System.out.println("kok          : "+ kok+ " (free x1)");
                        System.out.println("Harga lapang : "+promo);
                        System.out.println("Total Bayar  : "+ promo );
                        System.out.println("terdata      : "+formatterdDate);
                        System.out.println("");
                       System.out.println("harga yang harus di bayar : 50.000 ");
                       System.out.println("Bayar menggunakan BRI :093277367, BCA :3798759270820");
                       System.out.println("Bayar menggunakan Dana,Ovo no.0818044030");
                        System.out.println("");
                        System.out.println("Kirim Bukti transfer ke: 085122522156 untuk konfirmasi");  
                        System.out.println("Terimakasih telah membooking di GOR Banjalan...");
                        System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                     daftaruser.add(new bookin(bookingan,Nama,nohp,kok,waktuBooking,formatterdDate,total));
                    }
                        break;
                        
                        //KHUSUS
                        
                    case 2:
                   for (bookin use : daftaruser) {
                        System.out.print("Nama: " + use.nama() + " , NoHP: " + use.noHp()+ " , paket: " + use.Paket+ "waktu" + use.waktuBooking());
                        System.out.println( ", pada jam: " + listkode);
        }
                        System.out.println("Anda memilih Booking Khusus. (harga untuk 1 jam 50.000)");
                        bookingan = "khusus";
                        System.out.println("kegiatan yang bisa di lakukan:");
                        System.out.println("pernikahan,turnamen,pengajian,seminar,senam");
                        System.out.println("jika kegiatan tidak termasuk kegiatan diatas kontak admin di akhir ");
                        System.out.print("masukan kegiatan: ");
                        kegiatan = scanner.next();
                        System.out.print("Ingin Membooking berapa jam(masukan angka): ");
                        jam = scanner.nextInt();
                        System.out.println("Waktu yang tersedia");
                   for (String waktu : jadwalLapangan) {
                        System.out.println(waktu + " ");
                         }
                        System.out.println("Masukkan waktu yang ingin Anda booking (hh:mm) (pisahkan dengan koma jika lebih dari satu): ");
                        System.out.println("contoh 09:00,10:00 (untuk waktu 09:00-09:59,10:00-10:59)");
                        System.out.println("masukan waktu: ");;
                        waktuBooking = scanner.next();
                        listKode = waktuBooking.split(",");
                   for (i = 0; i < listKode.length; i++) {
                        listKode[i] = listKode[i].trim();
                        listkode.add(listKode[i]);
                        for (int j = 0; j < jadwalLapangan.length; j++) {
                    if (jadwalLapangan[j].equals(listKode[i])) {
                        jadwalLapangan[j] = "Booked";
                                       }
                                 }
                             } 
                        
                        int satujam = 50000;
                        total = satujam * jam;
                        System.out.println("");
                        System.out.println("Lakukan registrasi");
                        do{
                        System.out.print("Masukan Nama: ");
                        Nama = scanner.next();
                        huruf = Nama.matches("[a-zA-Z]+");
                        if (huruf) {
                         } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya huruf.");
                         }
                            } while (!huruf);                        
                        do{
                        System.out.print("Masukan no hp: ");
                        nohp = scanner.next();
                        angka = nohp.matches("[0-9]+");
                        if (angka) {
                        } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya angka.");
                         }
                        } while (!angka);
                        
                        System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                        System.out.println("\nTotal");
                        System.out.println("waktu, pukul : " + waktuBooking);
                        System.out.println("Lapang       : "+ jam +" jam" );
                        System.out.println("Total Bayar  : "+ total);
                        System.out.println("terdata      : "+formatterdDate);
                        System.out.println("Bayar menggunakan BRI :093277367, BCA :3798759270820");
                        System.out.println("Bayar menggunakan Dana,Ovo no.0818044030");
                        System.out.println("");
                        System.out.println("Kirim Bukti transfer ke: 085122522156 untuk konfirmasi");  
                        System.out.println("Terimakasih telah membooking di GOR Banjalan...");
                        usekhusus.add(new khusus(bookingan,Nama,nohp,kegiatan,waktuBooking,formatterdDate,total));
                        System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                        break;
                        
                        default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
                        
                        case 3:
                         break;   
                    }
                    } else if (choose == 3) {
                        
                // MENU MEMBER
                
                    boolean isRunning = true;
                    while (isRunning) {
                    System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                    System.out.println("\033[47m|                                       Selamat datang di GOR BANJALAN                                                   |");
                    System.out.println("\033[46m├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\033[0m");
                    System.out.println("\033[47m| Keteragan :                                                                                                            |");
                    System.out.println("\033[47m| -Harga Daftar paket Member Rp100.000                                                                                   |");
                    System.out.println("\033[47m| -bisa membooking 4x, 1 sesi berisi 2 jam selama sebulan waktu member                                                   |");
                    System.out.println("\033[47m| -tidak termasuk kok                                                                                                    |");
                    System.out.println("\033[47m|                                                                                                                        |");
                    System.out.println("\033[47m| 1. Daftar:                                                                                                             |");
                    System.out.println("\033[47m| 2. Login:                                                                                                              |");
                    System.out.println("\033[47m| 3. Exit:                                                                                                               |");
                    System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                   
                    System.out.print("Masukkan pilihan: ");
                    int action = scanner.nextInt();
                        System.out.println("");
                    scanner.nextLine(); // Membaca newline setelah nextInt()

                    switch (action) {
                        case 1:
                            System.out.print("Username: ");
                            String registerUsername = scanner.nextLine();
                            Nama = registerUsername;
                            System.out.print("Password: ");
                            String registerPassword = scanner.nextLine();
                            do{
                        System.out.print("Masukan no hp: ");
                        nohp = scanner.next();
                        angka = nohp.matches("[0-9]+");
                        if (angka) {
                        } else {
                              System.out.println("Input tidak valid. Harap masukkan hanya angka.");
                         }
                        } while (!angka);
                            register(registerUsername, registerPassword);
                            System.out.println("Lakukan pembayaran sebesar Rp100.000");
                            System.out.println("Bayar menggunakan BRI :093277367, BCA :3798759270820");
                       System.out.println("Bayar menggunakan Dana,Ovo no.0818044030");
                        System.out.println("");
                        System.out.println("Kirim Bukti transfer ke: 085122522156 untuk konfirmasi");  
                            
                            break;
                        case 2:
                            System.out.print("Username: ");
                            loginUsername = scanner.nextLine();
                            System.out.print("Password: ");
                            String loginPassword = scanner.nextLine();
                            if (login(loginUsername, loginPassword)) {
                                System.out.println("Login berhasil!");
                                
                    bookingan = "member";
                    String k;
                    
                    System.out.println("Sisa Jatah member: " + a);
                    System.out.print("ketik (ya) untuk melanjutkan (tidak) untuk kembali: ");
                    k = scanner.nextLine();
                    while (true)
                    if(k.equals("ya")){
                            a--;
                    System.out.println("");
                    System.out.println("Waktu yang tersedia");
                   for (String waktu : jadwalLapangan) {
                        System.out.println(waktu + " ");
                    }
                    System.out.println("Masukkan waktu yang ingin Anda booking (hh:mm) (pisahkan dengan koma jika lebih dari satu): ");
                    System.out.println("contoh 09:00,10:00 (untuk waktu 09:00-09:59,10:00-10:59)");
                    System.out.println("masukan waktu: ");
                    waktuBooking = scanner.next();
                    listKode = waktuBooking.split(",");
                    System.out.print("Ingin membeli berapa Kok?, satu kok seharga Rp18.000 : ");
                    kok = scanner.nextInt();
                    int kokharga = 18000;
                    total = kokharga * kok;
                    
                     System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                        System.out.println("\nTotal");
                        System.out.println("waktu pukul : "+waktuBooking );
                        System.out.println("kok         : " +kok);
                        System.out.println("lapang       : Member");
                        System.out.println("Total       : " + total);
                        System.out.println("terdata     : "+formatterdDate);
                        System.out.println("Lakukan pembayaran sebesar Rp100.000");
                       System.out.println("Bayar menggunakan BRI :093277367, BCA :3798759270820");
                       System.out.println("Bayar menggunakan Dana,Ovo no.0818044030");
                        System.out.println("");
                        System.out.println("Kirim Bukti transfer ke: 085122522156 untuk konfirmasi atau bisa langsung di tempat"); 
                        System.out.println("Terimakasih telah membooking di GOR Banjalan...");
                    System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");
                    
                    
                    for (i = 0; i < listKode.length; i++) {
                    listKode[i] = listKode[i].trim();
                    listkode.add(listKode[i]);
                    for (int j = 0; j < jadwalLapangan.length; j++) {
                        if (jadwalLapangan[j].equals(listKode[i])) {
                            jadwalLapangan[j] = "Booked";
                                }
                            }       
                        }
                    daftaruser.add(new bookin(bookingan,Nama,nohp,kok,waktuBooking,formatterdDate,total));
                            break;            
                     
                            
                    }else if (k.equals("tidak")
                            ){
                        break;
                        
                    }else{System.out.println("pilihn tidak valid");
                            }      
                    
                            } else {
                                System.out.println("Login gagal. Username atau password salah.");
                            }
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    }
                }
            } else if (choose == 4) {
                     System.out.println("\033[46m┌───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
                     System.out.println("\033[47m|                                         TENTANG KAMI & PERATURAN                                                       |");
                     System.out.println("\033[46m├───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\033[0m");
                     System.out.println("\033[47m|  Gor Banjalan adalah sebuah Gedung Olahraga yang bisa digunakan serbaguna, berisi satu lapang dengan luas 15,6m x 10m. |");
                     System.out.println("\033[47m|  Adapun beberapa peraturan yang ditetapkan disana seperti aturan;                                                      |");                                                   
                     System.out.println("\033[47m|  1. Dilarang membawa kok dari luar                                                                                     |");
                     System.out.println("\033[47m|  2. Dilarang merusak fasilitas yang ada di sana dengan sengaja                                                         |");
                     System.out.println("\033[47m|  3. Dilarang membawa senjata tajam atau benda yang membahayakan orang lain                                             |");
                     System.out.println("\033[47m|  4. Dilarang membawa barang-barang terlarang yang merugikan terutama merugikan banyak pihak                            |");
                     System.out.println("\033[47m|  5. Jika ada pertanyaan lebih lanjut siahkan hubungi no.0225940398                                                     |");
                     System.out.println("\033[47m|                                                                                                                        |");
                     System.out.println("\033[47m|  *ikuti arahan yang tercantum pada aplikasi ini, jika terjadi error/kesalahan siahkan hubungi no.08234567890           |");
                     System.out.println("\033[46m└───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘\033[0m");    
//    
             
            }
            
            System.out.print("Kembali ke beranda? (y/n): ");
            String jawaban = scanner.next().toLowerCase();
            inginMelakukanBooking = jawaban.equals("y");
            System.out.println("");
            }catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan hanya angka.");
                // Clear the scanner buffer
                scanner.nextLine();
            }
        }  
            scanner.close();
    }
}  