///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author jw91482
// */
//public class ReadFile {
//    
//    public static void main(String[] args) throws IOException{
//        //TODO code application logic here
//        
//        //read file.txt
//        
//        //create token1
//        String token1 = "";
//        
//        //for-each loop for calcualting heat index of May -  (not in mine)
//        
//        //create Scanner inFile1
//        Scanner inFile1 = new Scanner(new File("text.txt"));
//        
//        //Original answer used LinkedList, but probably preferable to to use ArrayList in most cases
//        //List<Strng> temps = new LinkedList<String>();
//        List<String> temps = new ArrayList<String>();
//        
//        //while loop
//        while (inFile1.hasNext()){
//            //find next line
//            token1 = inFile1.next();
//            temps.add(token1);
//        }
//        inFile1.close();
//        
//        String[] tempsArray = temps.toArray(new String[0]);
//    }
//}
//
//
////another potential solution
///*
//Scanner inFile1 = new Scanner(new File("text.txt"));
//
//StringBuilder sb = new Stringbuilder();
//while(inFile1.hasNext()){
//    sb.append(inFile1.nextLine()):
//}
//
//String[] yourArray = sb.toString().split(", ");
//*/
//
//
//
////another potential solution
///*
//List<String> list = Files.readAllLines(Paths.get("path/of/text"), StandardCharsets.UTF_8);
//String[] a = list.toArray(new String[list.size()]);
//*/
//
//
////another potential solution
///*
//BufferedReader in = new BufferedReader(new FileReader("path/of/text"));
//String str;
//
//List<String> list = new ArrayList<String>();
//while((str = in.readLine()) ! = null){
//    list.add(str);
//}
//
//String[] stringArr = list.toArray(new String[0]);
//*/