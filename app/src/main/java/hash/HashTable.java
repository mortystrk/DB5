package hash;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created on 30.09.2017.
 */

public class HashTable {

    //массив для хранения элементов
    private Item[] table;
    //количество элементов в таблице
    private int count;
    //размер таблицы
    private int size;

    public HashTable()
    {
        this.size = 10;
        table = new Item[size];
    }

    public int Hash(String key){
        int hash = key.hashCode() % size;

        /*for (int i = 0; i < key.length(); i++) {
            hash = (31 * hash + key.charAt(i)) % size;
        }*/
        return hash;
    }

    public void Insert(String key, String message, File file){
        Item item = new Item(key, message);
        int hash = Hash(item.getKey());
        table[hash] = item;
        WriteInFile(item.getMessage(), file);
    }

    public String Find(String key, File file) throws FileNotFoundException {
        int hash = Hash(key);
        if(table[hash].getKey().equals(key)){
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            if(line.equals(table[hash].getMessage())){
                scanner.close();
                return line;
            }
        }
        return "Значение не найдено";
    }

    public void WriteInFile(String message, File file){
        String str = message + "\r\n";
        try{
            FileWriter fw = new FileWriter(file, true);
            fw.append(str);
            fw.append("\r\n");
            fw.flush();
            fw.close();
            Log.d("Log_05", "Данные записаны");
        } catch (IOException e) {
            Log.d("Log_05", "Данные не записаны");
        }
    }
}
