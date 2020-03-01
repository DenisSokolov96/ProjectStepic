package org.denis.serializableAnimal;

import java.io.*;

public class MainSer {
    public static void main(String[] args) throws IOException {

        Animal[] animalM1 = {
                new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);

        for (Animal a : animalM1)
            oos.writeObject(a);
        oos.close();

        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        for (Animal a : animalM2)
            System.out.println(a);
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        int count = 0;
        Animal[] animals;

        ByteArrayInputStream dataInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream dataObj = new ObjectInputStream(dataInputStream);

            count = dataObj.readInt();
            animals = new Animal[count];

            int i = 0;
            while (i<count){
                Animal a = (Animal) dataObj.readObject();
                animals[i] = a;
                i++;
            }


        }catch (Exception e){
            throw new IllegalArgumentException();

        }

        return animals;
    }
}
