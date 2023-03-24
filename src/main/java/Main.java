
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String baseDir = "D://Games";
        String dirSrc = "D://Games/src";
        String dirRes = "D://Games/res";

        String dirMain = "D://Games/src/main";
        String dirTemp = "D://Games/temp";

//        File dirSrc = new File(baseDir,"src");
//        dirSrc.mkdir();
//        File dirMain = new File(dirSrc,"main");
//        dirMain.mkdir();
//        File item = new File(dirMain, "Utils.java");
//        item.createNewFile();

        List<String> listDirGames = Arrays.asList("src", "res", "savegames", "temp");
        List<String> listDirSrc = Arrays.asList("main", "test");
        List<String> listDirRes = Arrays.asList("drawables", "vectors", "icons");

        List<String> listFileMain = Arrays.asList("Main.java", "Utils.java");
        List<String> listFileTemp = Arrays.asList("temp.txt");

        createDir(baseDir, listDirGames);
        createDir(dirSrc, listDirSrc);
        createDir(dirRes, listDirRes);

        createFile(dirMain, listFileMain);
        createFile(dirTemp, listFileTemp);

        try (FileWriter writer = new FileWriter(dirTemp + "/temp.txt")) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void createDir(String dir, List<String> list) {
        for (String d : list) {
            File dirs = new File(dir, d);
            if (dirs.mkdir()) {
                System.out.println(dirs.getName() + " каталог создан");
            } else {
                System.out.println(dirs.getName() + " ошибка при создании каталога");
            }
            sb.append(dirs.getName() + " каталог создан" + "\n");
        }
    }

    public static void createFile(String dir, List<String> list) {
        for (String fileDir : list) {
            File file = new File(dir, fileDir);
            try {
                if (file.createNewFile()) {
                    System.out.println(file.getName() + " файл создан");
                } else {
                    System.out.println(file.getName() + " ошибка создания файла");
                }
                sb.append(file.getName() + " файл создан" + "\n");
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

}


