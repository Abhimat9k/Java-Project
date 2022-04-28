package Stock;
import java.util.*;
public class Stock {

  static Scanner in = new Scanner(System.in);     
    static int n;     
    static int l=0;     
    static int val2[] = new int[10];     
    static int m[]= new int [10];     
    void welcome_page(){ 
	        System.out.print("\033[H\033[2J"); 
	        System.out.flush(); 
	        
	System.out.println("\t*********************"); 
	 
	System.out.println("\t*********************"); 
	        System.out.println("\t         Welcome To The Project       "); 
	        System.out.println("\t                 Stock                "); 
	        System.out.println("\t                                      "); 
	       
	        
	System.out.println("\t*******"); 
	        
	System.out.println("\t*******"); 
	    } 
	     
	    void menu(){ 
	        System.out.println("\n"); 
	        System.out.println("\t\t\t   <<<<<  Main Menu >>>>>    "); 
	        System.out.println("\n"); 
	        System.out.println("\t\t 1. Input item in stock."); 
	        System.out.println("\t\t 2. Search item in stock by item no."); 
	        System.out.println("\t\t 3. Display stock data sorted by item name."); 
	        System.out.println("\t\t 4. Issue item in stock."); 
	        System.out.println("\t\t 5. Return item to stock"); 
	        System.out.println("\t\t 6. Exit."); 
	        System.out.println(" "); 
	    } 
	 
	public static void main(String[] args){         
            int choice; 
	        Items [] list = new Items[100];         
                Stock obj = new Stock(); 
	        obj.welcome_page();         
                do{             
                    obj.menu(); 
                    System.out.print("\nEnter choice: ");             
                    choice = in.nextInt(); 
	            switch(choice){ 
	 
	case 1: System.out.print("\nEnter how many items want to record in stock: ");                         
        n = in.nextInt();             
        for(int i=0;i<n;i++){ 
	                System.out.print("\n\t\tItem record "+(i+1)+": \n");                  
                        list[i] = new Items();                   
                        for(int j=0;j<i;j++){ 
	                   if((list[j].get_item_no()==list[i].get_item_no()) && 
	(list[j].get_quantity()==list[i].get_quantity()) ){ 
	                        System.out.print("\nNo products have neither same item no nor quantity less than 5 !!!!"); 
	                         System.out.print("\nPlease enter the above details again!!!!");                                     
	                                    --i;                                     
                                            break; 
	                                } 
	                            } 
	                        } 
	                        System.out.print("\033[H\033[2J"); 
	                        System.out.flush(); 
	                        System.out.println("\nThe entered item record is: \n\n"); 
	                        System.out.printf("%-15s %-20s %-20s %-23s ","Item no.","Company Name"," Item name","Quantity"); 
	                        System.out.println("\n"); 
	 
	                        for(int i=0 ; i<n ; i++){ 
	                            System.out.printf("%-15s %-20s %-20s %-23s ",list[i].get_item_no(),
	 list[i].get_company_name(),list[i].get_item_name(),list[i].get_quantity()); 
	                            System.out.println("\n");  
	                        }                    
                                break; 
	 
	 case 2: int val;                         
	                        System.out.print("\nEnter item no want to search for: ");
	                        val = in.nextInt();
	                        System.out.println("\n"); 
	                        System.out.printf("%-15s %-20s %-20s %-23s ","Item no.","Company Name"," Item name","Quantity"); 
	                        System.out.println("\n");                         
                                for(int i=0; i<n ;i++){ 
	                            if(list[i].get_item_no()==val){ 
	                                System.out.printf("%-15s %-20s %-20s %-23s ",list[i].get_item_no(),list[i].get_company_name(),list[i].get_item_name(),list[i].get_quantity
	()); 
	                                System.out.println("\n"); 
	                            } 
	                        } 
	 
	                        break; 
	 
	  case 3: System.out.print("\033[H\033[2J"); 
	                        System.out.flush(); 
	                        System.out.print("\nThe item details stored in stock sorted by name are: ");                         Items temp; 
	                        System.out.println("\n");                         
                                for(int k=0; k<n; k++){ 
	                            for(int i=k; i<n; i++) 
	                            
	if(list[k].get_item_name().compareToIgnoreCase(list[i].get_item_name())>0){                                
            temp=list[k];                                
            list[k]=list[i];                                
            list[i]=temp; 
	                            } 
	                        } 
	 
	                        System.out.printf("\n%-15s %-20s %-20s %-23s ","Item no.","Company Name"," Item name","Quantity"); 
	                        System.out.println("\n");                     
	                 
	                        for(int i=0 ; i<n ; i++){ 
	                            System.out.printf("%-15s %-20s %-20s %-23s ",list[i].get_item_no(),list[i].get_company_name(),list[i].get_item_name(),list[i].get_quantity
	()); 
	                            System.out.println("\n"); 
	                        }                         
                                break; 
	 
	  case 4: System.out.print("\nEnter the name of item wants to issue: "); 
	                        String str = in.next(); 
	                         
	                        for(int i=0; i<n ;i++){ 
	                            if(list[i].get_item_name().compareToIgnoreCase(str)==0){                                 
                                        m[l]=i; 
	                            } 
	                        } 
	                                if(list[m[l]].get_quantity()>5){ 
	                                    System.out.print("\nItem is available to issue are:"+list[m[l]].get_quantity()); 
	                                    System.out.print("\nHow much item you want to issue: ");                                     
                                            val2[l] = in.nextInt(); 
	                                    list[m[l]].qty = list[m[l]].qty-val2[l]; 
	                                    ++l;                  
	                                }                  
	                        System.out.print("\nThe remaining items are: \n"); 
	                        System.out.printf("%-15s %-20s %-20s %-23s ","Item no.","Company Name"," Item name","Quantity"); 
	                        System.out.println("\n");                     
	                 
	                        for(int i=0 ; i<n ; i++){ 
	                            System.out.printf("%-15s %-20s %-20s %-23s ",list[i].get_item_no(),list[i].get_company_name(),list[i].get_item_name(),list[i].get_quantity
	()); 
	                            System.out.println("\n"); 
	                        }                         
                                break; 
	 
	case 5: System.out.print("\033[H\033[2J"); 
	                       System.out.flush();  
	                        System.out.print("\nThe items issued are returned to stock: \n"); 
	                         
	                        System.out.print("\nThe items present currently are: \n"); 
	                        System.out.printf("%-15s %-20s %-20s %-23s ","Item no.","Company Name"," Item name","Quantity"); 
	                        System.out.println("\n");                            
                                for(int i=0;i<l;i++)                                          
                                    list[m[i]].qty = list[m[i]].qty+val2[i]; 
	                        for(int i=0 ; i<n ; i++){ 
	                             System.out.printf("%-15s %-20s %-20s %-23s ",list[i].get_item_no(),list[i].get_company_name(),list[i].get_item_name(),list[i].get_quantity
	()); 
	                             System.out.println("\n"); 
	                        } 
	                       break;
        case 6: System.out.print("\033[H\033[2J"); 
	                        System.out.flush(); 
	                        System.out.println("\n\n\n\t\t\t <<<< Thankyou, visit again :) >>>>>\n\n");                         break; 
	                default: 
                            System.out.print("\nEntered wrong choice!! Please enter again (:");                          break;             
	            } 
	        }while(choice!=6); 
	    } } 
	 
	class Items{ 
	    Scanner in = new Scanner(System.in);     
            String company_name , item_name; 
	    int item_no,qty; 
	 
	    Items(){ 
	         
	        System.out.print("\nItem Name:         ");         
                item_name=in.nextLine(); 
	        System.out.print("\nComapany Name:     ");         
                company_name=in.nextLine(); 
	        System.out.print("\nItem no.:          ");         
                item_no=in.nextInt();         
                System.out.print("\nQuantity (min. 5): "); 
	        qty=in.nextInt(); 
	         
	    } 
	    String get_item_name(){ 
	        return item_name; 
	    } 
	 
	    String get_company_name(){ 
	        return company_name; 
	    } 
	    int get_item_no(){ 
	        return item_no; 
	    } 
	   int get_quantity(){         
               return qty; 
	    } 
	   }
