/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GamePackage;

import DataBaseConnections.CrudUtil;
import java.awt.Component;
import java.net.URL;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */
public class FormPuzzleGUIPage extends javax.swing.JFrame{
    ClassSound sound = new ClassSound();    
    URL soundbtnpressURL = getClass().getResource("presswithclicks.wav");
    URL soundbtnclickURL = getClass().getResource("button-click.wav");
    static int ms =0;
    static int s =0;
    static int m =30;
    private String name;
    public static boolean state = true;
       
    public FormPuzzleGUIPage() {
        initComponents();
        ShuffleNumber();   
    }
    
    public int clickcount = 0;
    
    public void EmptySpotChecker(JButton btnx, JButton btny) {
        if (btny.getText() == "") {
            btny.setText(btnx.getText());
            playbuttonpressclicksound(soundbtnpressURL);
            btnx.setText("");
            clickcount++;
            lblcount.setText(String.valueOf(clickcount));
        }
        if(clickcount == 1){
            timer();
        } 
        if(btn1.getText().equals("1")&&btn2.getText().equals("2")&&btn3.getText().equals("3")&&btn4.getText().equals("4")&&btn5.getText().equals("5")&&btn6.getText().equals("6")&&btn7.getText().equals("7")&&btn8.getText().equals("8")&&btn9.getText().equals("9")&&btn10.getText().equals("10")&&btn11.getText().equals("11")&&btn12.getText().equals("12")&&btn13.getText().equals("13")&&btn14.getText().equals("14")&&btn15.getText().equals("15")&&btn16.getText().equals("")){
            timerStop();  
            this.toBack();

            try {  
                FormWinPage wf = new FormWinPage();
                wf.setVisible(true);
                wf.toFront();
                CrudUtil.execute("INSERT INTO Players VALUES (?, ?,?,?)", name, clickcount,30-m,1);                       
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace(); // Print the stack trace for debugging
            }                        
        }
    }
    
    public void playbuttonpressclicksound(URL url){
        sound.setFile(url);
        sound.play(url);
    }

    public void buttonclicksound(URL url){
        sound.setFile(url);
        sound.play(url);
    }
    
    public void setPlayername(String name){
        this.name = name;
    }
    private void ShuffleNumber(){         
        boolean flag = false;        
        int[] numbers = new int[15];
        int i=0;
        do{
            Random randomNumber = new Random();
            int rndNum = randomNumber.nextInt(15)+1;            
            if(i==0){
                numbers[i] = rndNum;
                i++;
            }else{
                for(int j=15-i;j<15;j++){
                    if(numbers[14-j] == rndNum ){
                        flag =true;
                    }
                }
                if(flag == true){
                    flag = false;
                }else{
                   numbers[i] = rndNum; 
                   i++;
                }                
            }           
        }while(i<15);
        btn1.setText(String.valueOf(numbers[0]));
        btn2.setText(String.valueOf(numbers[1]));
        btn3.setText(String.valueOf(numbers[2]));
        btn4.setText(String.valueOf(numbers[3]));
        btn5.setText(String.valueOf(numbers[4]));
        btn6.setText(String.valueOf(numbers[5]));
        btn7.setText(String.valueOf(numbers[6]));
        btn8.setText(String.valueOf(numbers[7]));
        btn9.setText(String.valueOf(numbers[8]));
        btn10.setText(String.valueOf(numbers[9]));
        btn11.setText(String.valueOf(numbers[10]));
        btn12.setText(String.valueOf(numbers[11]));
        btn13.setText(String.valueOf(numbers[12]));
        btn14.setText(String.valueOf(numbers[13]));
        btn15.setText(String.valueOf(numbers[14]));
        btn16.setText("");
    }
    
    public void timerStop(){
       state = false;
    }
    public void timerStart(){
      if(clickcount==1){
       state = true;
       }
    }
    
    public void timer(){
        state = true;
        Thread t = new Thread(){
            public void run(){
                for(;;){
                    if(state == true){
                        try{
                            sleep(1);
                            if(m>1){
                                if(ms<1){
                                    ms=1000;
                                    s--;
                                }
                                if(s<1){
                                    ms=1000;
                                    s=59;
                                    m--;
                                }                                    
                                ms--;
                                lbltsec.setText(": "+s);
                                lbltmin.setText(""+m); 
                            }else if(m==1&& s==59){
                                timerStop();            
                                try {
                                    FormGameOverPage gof = new FormGameOverPage();
                                    gof.setVisible(true);  
                                    CrudUtil.execute("INSERT INTO Players VALUES (?, ?,?,?)", name, clickcount,30,0);
                                    
                                } catch (SQLException | ClassNotFoundException e) {
                                    e.printStackTrace(); // Print the stack trace for debugging
                                }
                            }                         
                        }catch(Exception ex){
                       
                        }
                    }else{
                        break;
                    }
                }
            }
        };
        t.start();
    }
    
    private void disablePanelComponents(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            component.setEnabled(false);
        }
    }
    
    private void enablePanelComponents(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            component.setEnabled(true);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new GamePackage.ClassButtonGradient();
        btn2 = new GamePackage.ClassButtonGradient();
        btn3 = new GamePackage.ClassButtonGradient();
        btn4 = new GamePackage.ClassButtonGradient();
        btn8 = new GamePackage.ClassButtonGradient();
        btn7 = new GamePackage.ClassButtonGradient();
        btn6 = new GamePackage.ClassButtonGradient();
        btn5 = new GamePackage.ClassButtonGradient();
        btn9 = new GamePackage.ClassButtonGradient();
        btn10 = new GamePackage.ClassButtonGradient();
        btn11 = new GamePackage.ClassButtonGradient();
        btn12 = new GamePackage.ClassButtonGradient();
        btn16 = new GamePackage.ClassButtonGradient();
        btn15 = new GamePackage.ClassButtonGradient();
        btn14 = new GamePackage.ClassButtonGradient();
        btn13 = new GamePackage.ClassButtonGradient();
        lblclickcount = new javax.swing.JLabel();
        lblcount = new javax.swing.JLabel();
        btnreset = new GamePackage.ClassButtonGradient();
        btnexit = new GamePackage.ClassButtonGradient();
        btnrestart = new GamePackage.ClassButtonGradient();
        btnpause = new GamePackage.ClassButtonGradient();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbltmin = new javax.swing.JLabel();
        lbltsec = new javax.swing.JLabel();
        lblfunnypuzzletext = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblbgmickey = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(640, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(640, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 480));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255,255,80));
        jPanel2.setPreferredSize(new java.awt.Dimension(310, 312));
        jPanel2.setRequestFocusEnabled(false);

        btn1.setText("1");
        btn1.setColor1(new java.awt.Color(0, 0, 102));
        btn1.setColor2(new java.awt.Color(51, 255, 255));
        btn1.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn1.setIconTextGap(2);
        btn1.setMaximumSize(new java.awt.Dimension(70, 70));
        btn1.setMinimumSize(new java.awt.Dimension(70, 70));
        btn1.setPreferredSize(new java.awt.Dimension(60, 60));
        btn1.setSizeSpeed(5.0F);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1);

        btn2.setText("2");
        btn2.setColor1(new java.awt.Color(0, 0, 102));
        btn2.setColor2(new java.awt.Color(51, 255, 255));
        btn2.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn2.setIconTextGap(2);
        btn2.setMaximumSize(new java.awt.Dimension(70, 70));
        btn2.setMinimumSize(new java.awt.Dimension(70, 70));
        btn2.setPreferredSize(new java.awt.Dimension(60, 60));
        btn2.setSizeSpeed(5.0F);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2);

        btn3.setText("3");
        btn3.setColor1(new java.awt.Color(0, 0, 102));
        btn3.setColor2(new java.awt.Color(51, 255, 255));
        btn3.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn3.setIconTextGap(2);
        btn3.setMaximumSize(new java.awt.Dimension(70, 70));
        btn3.setMinimumSize(new java.awt.Dimension(70, 70));
        btn3.setPreferredSize(new java.awt.Dimension(60, 60));
        btn3.setSizeSpeed(5.0F);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3);

        btn4.setText("4");
        btn4.setColor1(new java.awt.Color(0, 0, 102));
        btn4.setColor2(new java.awt.Color(51, 255, 255));
        btn4.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn4.setIconTextGap(2);
        btn4.setMaximumSize(new java.awt.Dimension(70, 70));
        btn4.setMinimumSize(new java.awt.Dimension(70, 70));
        btn4.setPreferredSize(new java.awt.Dimension(60, 60));
        btn4.setSizeSpeed(5.0F);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4);

        btn8.setText("8");
        btn8.setColor1(new java.awt.Color(0, 0, 102));
        btn8.setColor2(new java.awt.Color(51, 255, 255));
        btn8.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn8.setIconTextGap(2);
        btn8.setMaximumSize(new java.awt.Dimension(70, 70));
        btn8.setMinimumSize(new java.awt.Dimension(70, 70));
        btn8.setPreferredSize(new java.awt.Dimension(60, 60));
        btn8.setSizeSpeed(5.0F);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8);

        btn7.setText("7");
        btn7.setColor1(new java.awt.Color(0, 0, 102));
        btn7.setColor2(new java.awt.Color(51, 255, 255));
        btn7.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn7.setIconTextGap(2);
        btn7.setMaximumSize(new java.awt.Dimension(70, 70));
        btn7.setMinimumSize(new java.awt.Dimension(70, 70));
        btn7.setPreferredSize(new java.awt.Dimension(60, 60));
        btn7.setSizeSpeed(5.0F);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7);

        btn6.setText("6");
        btn6.setColor1(new java.awt.Color(0, 0, 102));
        btn6.setColor2(new java.awt.Color(51, 255, 255));
        btn6.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn6.setIconTextGap(2);
        btn6.setMaximumSize(new java.awt.Dimension(70, 70));
        btn6.setMinimumSize(new java.awt.Dimension(70, 70));
        btn6.setPreferredSize(new java.awt.Dimension(60, 60));
        btn6.setSizeSpeed(5.0F);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6);

        btn5.setText("5");
        btn5.setColor1(new java.awt.Color(0, 0, 102));
        btn5.setColor2(new java.awt.Color(51, 255, 255));
        btn5.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn5.setIconTextGap(2);
        btn5.setMaximumSize(new java.awt.Dimension(70, 70));
        btn5.setMinimumSize(new java.awt.Dimension(70, 70));
        btn5.setPreferredSize(new java.awt.Dimension(60, 60));
        btn5.setSizeSpeed(5.0F);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5);

        btn9.setText("9");
        btn9.setColor1(new java.awt.Color(0, 0, 102));
        btn9.setColor2(new java.awt.Color(51, 255, 255));
        btn9.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn9.setIconTextGap(2);
        btn9.setMaximumSize(new java.awt.Dimension(70, 70));
        btn9.setMinimumSize(new java.awt.Dimension(70, 70));
        btn9.setPreferredSize(new java.awt.Dimension(60, 60));
        btn9.setSizeSpeed(5.0F);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9);

        btn10.setText("10");
        btn10.setColor1(new java.awt.Color(0, 0, 102));
        btn10.setColor2(new java.awt.Color(51, 255, 255));
        btn10.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn10.setIconTextGap(2);
        btn10.setMaximumSize(new java.awt.Dimension(70, 70));
        btn10.setMinimumSize(new java.awt.Dimension(70, 70));
        btn10.setPreferredSize(new java.awt.Dimension(60, 60));
        btn10.setSizeSpeed(5.0F);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel2.add(btn10);

        btn11.setText("11");
        btn11.setColor1(new java.awt.Color(0, 0, 102));
        btn11.setColor2(new java.awt.Color(51, 255, 255));
        btn11.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn11.setIconTextGap(2);
        btn11.setMaximumSize(new java.awt.Dimension(70, 70));
        btn11.setMinimumSize(new java.awt.Dimension(70, 70));
        btn11.setPreferredSize(new java.awt.Dimension(60, 60));
        btn11.setSizeSpeed(5.0F);
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel2.add(btn11);

        btn12.setText("12");
        btn12.setColor1(new java.awt.Color(0, 0, 102));
        btn12.setColor2(new java.awt.Color(51, 255, 255));
        btn12.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn12.setIconTextGap(2);
        btn12.setMaximumSize(new java.awt.Dimension(70, 70));
        btn12.setMinimumSize(new java.awt.Dimension(70, 70));
        btn12.setPreferredSize(new java.awt.Dimension(60, 60));
        btn12.setSizeSpeed(5.0F);
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel2.add(btn12);

        btn16.setColor1(new java.awt.Color(0, 0, 102));
        btn16.setColor2(new java.awt.Color(51, 255, 255));
        btn16.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn16.setIconTextGap(2);
        btn16.setMaximumSize(new java.awt.Dimension(70, 70));
        btn16.setMinimumSize(new java.awt.Dimension(70, 70));
        btn16.setPreferredSize(new java.awt.Dimension(60, 60));
        btn16.setSizeSpeed(5.0F);
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });
        jPanel2.add(btn16);

        btn15.setText("15");
        btn15.setColor1(new java.awt.Color(0, 0, 102));
        btn15.setColor2(new java.awt.Color(51, 255, 255));
        btn15.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn15.setIconTextGap(2);
        btn15.setMaximumSize(new java.awt.Dimension(70, 70));
        btn15.setMinimumSize(new java.awt.Dimension(70, 70));
        btn15.setPreferredSize(new java.awt.Dimension(60, 60));
        btn15.setSizeSpeed(5.0F);
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });
        jPanel2.add(btn15);

        btn14.setText("14");
        btn14.setColor1(new java.awt.Color(0, 0, 102));
        btn14.setColor2(new java.awt.Color(51, 255, 255));
        btn14.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn14.setIconTextGap(2);
        btn14.setMaximumSize(new java.awt.Dimension(70, 70));
        btn14.setMinimumSize(new java.awt.Dimension(70, 70));
        btn14.setPreferredSize(new java.awt.Dimension(60, 60));
        btn14.setSizeSpeed(5.0F);
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });
        jPanel2.add(btn14);

        btn13.setText("13");
        btn13.setColor1(new java.awt.Color(0, 0, 102));
        btn13.setColor2(new java.awt.Color(51, 255, 255));
        btn13.setFont(new java.awt.Font("Perpetua Titling MT", 3, 18)); // NOI18N
        btn13.setIconTextGap(2);
        btn13.setMaximumSize(new java.awt.Dimension(70, 70));
        btn13.setMinimumSize(new java.awt.Dimension(70, 70));
        btn13.setPreferredSize(new java.awt.Dimension(60, 60));
        btn13.setSizeSpeed(5.0F);
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        jPanel2.add(btn13);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 260, 270));

        lblclickcount.setBackground(new java.awt.Color(255, 255, 255,100));
        lblclickcount.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblclickcount.setText("Clicks");
        lblclickcount.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblclickcount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblclickcount.setOpaque(true);
        lblclickcount.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblclickcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        lblcount.setBackground(new java.awt.Color(102, 204, 255));
        lblcount.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblcount.setText("0");
        lblcount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblcount.setOpaque(true);
        jPanel1.add(lblcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 90, 30));

        btnreset.setForeground(new java.awt.Color(0, 0, 0));
        btnreset.setText("Reset");
        btnreset.setColor1(new java.awt.Color(255, 255, 255));
        btnreset.setColor2(new java.awt.Color(0, 204, 51));
        btnreset.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnreset.setSizeSpeed(5.0F);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 110, 30));

        btnexit.setForeground(new java.awt.Color(0, 0, 0));
        btnexit.setText("Exit");
        btnexit.setColor1(new java.awt.Color(255, 255, 255));
        btnexit.setColor2(new java.awt.Color(255, 0, 51));
        btnexit.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnexit.setSizeSpeed(5.0F);
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel1.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 110, 30));

        btnrestart.setForeground(new java.awt.Color(0, 0, 0));
        btnrestart.setText("Restart");
        btnrestart.setColor1(new java.awt.Color(255, 255, 255));
        btnrestart.setColor2(new java.awt.Color(255, 153, 0));
        btnrestart.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnrestart.setSizeSpeed(5.0F);
        btnrestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestartActionPerformed(evt);
            }
        });
        jPanel1.add(btnrestart, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 110, 30));

        btnpause.setForeground(new java.awt.Color(0, 0, 0));
        btnpause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePackage/Pause.png"))); // NOI18N
        btnpause.setColor1(new java.awt.Color(0, 204, 51));
        btnpause.setColor2(new java.awt.Color(255, 255, 51));
        btnpause.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnpause.setSizeSpeed(5.0F);
        btnpause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpauseActionPerformed(evt);
            }
        });
        jPanel1.add(btnpause, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 40, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255,100));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Time");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        lbltmin.setBackground(new java.awt.Color(0, 0, 0,100));
        lbltmin.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbltmin.setText("30");
        lbltmin.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel3.add(lbltmin);

        lbltsec.setBackground(new java.awt.Color(0, 0, 0,100));
        lbltsec.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbltsec.setText(": 00");
        lbltsec.setMaximumSize(new java.awt.Dimension(40, 22));
        lbltsec.setMinimumSize(new java.awt.Dimension(40, 22));
        lbltsec.setPreferredSize(new java.awt.Dimension(45, 25));
        jPanel3.add(lbltsec);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, -1));

        lblfunnypuzzletext.setBackground(new java.awt.Color(255,255,255,100));
        lblfunnypuzzletext.setFont(new java.awt.Font("Stencil", 1, 30)); // NOI18N
        lblfunnypuzzletext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfunnypuzzletext.setText("Funny Puzzle");
        lblfunnypuzzletext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblfunnypuzzletext.setOpaque(true);
        jPanel1.add(lblfunnypuzzletext, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 640, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePackage/Duck.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 210));

        lblbgmickey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePackage/Mickey1.png"))); // NOI18N
        jPanel1.add(lblbgmickey, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 140, 180));

        lblbackground.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GamePackage/A Beach.jpg"))); // NOI18N
        lblbackground.setOpaque(true);
        jPanel1.add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        EmptySpotChecker(btn1,btn2);
        EmptySpotChecker(btn1,btn8);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        EmptySpotChecker(btn2,btn1);
        EmptySpotChecker(btn2,btn3);
        EmptySpotChecker(btn2,btn7);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        EmptySpotChecker(btn3,btn2);
        EmptySpotChecker(btn3,btn4);
        EmptySpotChecker(btn3,btn6);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        EmptySpotChecker(btn4,btn3);
        EmptySpotChecker(btn4,btn5);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        EmptySpotChecker(btn5,btn4);
        EmptySpotChecker(btn5,btn6);
        EmptySpotChecker(btn5,btn12);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        EmptySpotChecker(btn6,btn3);
        EmptySpotChecker(btn6,btn5);
        EmptySpotChecker(btn6,btn7);
        EmptySpotChecker(btn6,btn11);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        EmptySpotChecker(btn7,btn2);
        EmptySpotChecker(btn7,btn6);
        EmptySpotChecker(btn7,btn8);
        EmptySpotChecker(btn7,btn10);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        EmptySpotChecker(btn8,btn1);
        EmptySpotChecker(btn8,btn7);
        EmptySpotChecker(btn8,btn9);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        EmptySpotChecker(btn9,btn8);
        EmptySpotChecker(btn9,btn10);
        EmptySpotChecker(btn9,btn16);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        EmptySpotChecker(btn10,btn7);
        EmptySpotChecker(btn10,btn9);
        EmptySpotChecker(btn10,btn11);
        EmptySpotChecker(btn10,btn15);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        EmptySpotChecker(btn11,btn6);
        EmptySpotChecker(btn11,btn10);
        EmptySpotChecker(btn11,btn12);
        EmptySpotChecker(btn11,btn14);
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        EmptySpotChecker(btn12,btn5);
        EmptySpotChecker(btn12,btn11);
        EmptySpotChecker(btn12,btn13);
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        EmptySpotChecker(btn13,btn12);
        EmptySpotChecker(btn13,btn14);
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        EmptySpotChecker(btn14,btn11);
        EmptySpotChecker(btn14,btn13);
        EmptySpotChecker(btn14,btn15);
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        EmptySpotChecker(btn15,btn10);
        EmptySpotChecker(btn15,btn14);
        EmptySpotChecker(btn15,btn16);
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        EmptySpotChecker(btn16,btn9);
        EmptySpotChecker(btn16,btn15);
    }//GEN-LAST:event_btn16ActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        buttonclicksound(soundbtnclickURL );
        ShuffleNumber();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        buttonclicksound(soundbtnclickURL );
        this.toBack();
        FormExitPage ef = new FormExitPage();
        ef.setVisible(true);
        ef.toFront();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnpauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpauseActionPerformed
        buttonclicksound(soundbtnclickURL );        
        // Load icons from resources
        Icon pauseIcon = new ImageIcon(getClass().getResource("Pause.png"));
        Icon continueIcon = new ImageIcon(getClass().getResource("Continue.png"));
        // Get the current icon of the button
        Icon currentIcon = btnpause.getIcon();
        // Compare icon filenames to determine the current state
        if (currentIcon != null) {
            if (currentIcon.toString().contains("Pause.png")) {
                btnpause.setIcon(continueIcon);
                btnrestart.setEnabled(false);
                btnreset.setEnabled(false);
                btnexit.setEnabled(false);
                timerStop();
                disablePanelComponents(jPanel2);
            } else if (currentIcon.toString().contains("Continue.png")) {
                btnpause.setIcon(pauseIcon);
                btnrestart.setEnabled(true);
                btnreset.setEnabled(true);
                btnexit.setEnabled(true);
                timer();
                enablePanelComponents(jPanel2);
            }
        }         
    }//GEN-LAST:event_btnpauseActionPerformed

    private void btnrestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestartActionPerformed
        buttonclicksound(soundbtnclickURL ); 
        timerStop();
        try {
            Thread.sleep(100); // Wait for 100 milliseconds
        } catch (InterruptedException ex) {
            // Handle InterruptedException if needed
            ex.printStackTrace();
        }
        clickcount=0;
        lbltsec.setText(" : 00");
        lbltmin.setText("30");  
        ms =0;
        s =0;
        m =30;        
        lblcount.setText(String.valueOf(clickcount));                       
        ShuffleNumber();        
        timerStart();
    }//GEN-LAST:event_btnrestartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPuzzleGUIPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPuzzleGUIPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPuzzleGUIPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPuzzleGUIPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPuzzleGUIPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GamePackage.ClassButtonGradient btn1;
    private GamePackage.ClassButtonGradient btn10;
    private GamePackage.ClassButtonGradient btn11;
    private GamePackage.ClassButtonGradient btn12;
    private GamePackage.ClassButtonGradient btn13;
    private GamePackage.ClassButtonGradient btn14;
    private GamePackage.ClassButtonGradient btn15;
    private GamePackage.ClassButtonGradient btn16;
    private GamePackage.ClassButtonGradient btn2;
    private GamePackage.ClassButtonGradient btn3;
    private GamePackage.ClassButtonGradient btn4;
    private GamePackage.ClassButtonGradient btn5;
    private GamePackage.ClassButtonGradient btn6;
    private GamePackage.ClassButtonGradient btn7;
    private GamePackage.ClassButtonGradient btn8;
    private GamePackage.ClassButtonGradient btn9;
    private GamePackage.ClassButtonGradient btnexit;
    private GamePackage.ClassButtonGradient btnpause;
    private GamePackage.ClassButtonGradient btnreset;
    private GamePackage.ClassButtonGradient btnrestart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbgmickey;
    private javax.swing.JLabel lblclickcount;
    private javax.swing.JLabel lblcount;
    private javax.swing.JLabel lblfunnypuzzletext;
    private javax.swing.JLabel lbltmin;
    private javax.swing.JLabel lbltsec;
    // End of variables declaration//GEN-END:variables
}
