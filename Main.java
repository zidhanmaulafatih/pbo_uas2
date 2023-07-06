
package todolist_uas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String url = "jdbc:mysql://localhost/uaspbo";
    private static String username = "root";
    private static String password = "";

    public static void main(String[] args) {
        Todolist_uas todolist_uas = new Todolist_uas(url, username, password);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Daftar Todo List ");
            System.out.println("1. Tampilan Todo List ");
            System.out.println("2. Tambah Todo List ");
            System.out.println("3. Update Todo List");
            System.out.println("4. Hapus Todo List");
            System.out.println("5. Keluar Menu");
            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Data:");
                    todolist_uas.displayData();
                    break;
                case 2:
                    // Mengambil input data baru
                    System.out.print("Masukkan ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Masukkan Todo List : ");
                    String todo = scanner.nextLine();
                    System.out.print("Masukkan Kategori Todo List : ");
                    String kategori = scanner.nextLine();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Tanggal-Selesai : ");
                    String tanggal_selesai = scanner.nextLine();
                    System.out.print("Status Todo List : ");
                    String status = scanner.nextLine();

                    // Menambahkan data baru
                    todolist_uas.createData(id, todo, kategori, tanggal_selesai, status);
                    System.out.println("Data berhasil ditambahkan !");
                    break;
                case 3:
                    // Mengambil input data yang akan diupdat3e
                    System.out.print("Masukkan ID yang ingin diupdate: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Masukkan Todo List Baru : ");
                    String newTodo = scanner.nextLine();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Masukkan Kategori Todo List Baru : ");
                    String newKategori = scanner.nextLine();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Tanggal-Selesai Baru : ");
                    String newTanggal_selesai = scanner.nextLine();
                    System.out.print("Status Todo List Baru : ");
                    String newStatus = scanner.nextLine();

                    // Mengupdate data
                    todolist_uas.createData(idToUpdate, newTodo, newKategori, newTanggal_selesai, newStatus);
                    System.out.println("Data berhasil diupdate !");
                    break;
                case 4:
                    // Mengambil input data yang akan dihapus
                    System.out.print("Masukkan ID barang yang ingin dihapus : ");
                    int idToDelete = scanner.nextInt();

                    // Menghapus data
                    todolist_uas.deleteData(idToDelete);
                    System.out.println("Data berhasil dihapus !");
                    break;
                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan pilih menu (1-5).");
                    break;
            }

            System.out.println();
            System.out.println();
            System.out.println();
        }

        scanner.close();
    }
}