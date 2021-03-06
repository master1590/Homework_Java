package homework.Forms;

import homework.Utils.TasksTableRenderer;
import homework.Entities.Solution;
import homework.Entities.Task;
import homework.Users.SimpleUser;
import homework.Utils.ToastMessage;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import resources.LocalizationUtil;

public class SimpleUserMenu extends javax.swing.JFrame implements ListSelectionListener, ListCellRenderer {

    private final ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Images/icon.gif"));
    private ImageIcon langIcon = new ImageIcon(getClass().getResource("/Images/LangIcon.png"));
    private static String Language = LocalizationUtil.localizedResourceBundle.getLocale().getLanguage();
    private SimpleUser currentUser = new SimpleUser();
    private DefaultListModel solutionsListModel = new DefaultListModel();
    private ArrayList<String> solutions = new ArrayList<>();
    private final Color markGreen = new Color(155, 255, 155);
    private final Color approvedColor = new Color(0, 102, 0);
    private final Color markRed = new Color(255, 101, 101);
    private final Color voteBlue = new Color(0, 153, 153);
    private final Color voteRed = new Color(255, 101, 101);
    private HashSet<Solution> localSolutions = new HashSet<Solution>();

    public SimpleUserMenu(String email, String password) {
        initComponents();
        setComponentsAvailable(false);
        setIconImage(imgIcon.getImage());
        setVisible(true);
        btnSuggestSolution.setVisible(false);
        btnVote.setVisible(false);
        solutionsList.addListSelectionListener(this);

        //set language icon to button
        Image img = langIcon.getImage();
        Image newimg = img.getScaledInstance(btnLanguage.getWidth(), btnLanguage.getHeight(), java.awt.Image.SCALE_SMOOTH);
        langIcon = new ImageIcon(newimg);
        btnLanguage.setIcon(langIcon);

        Thread t = new Thread() {
            public void run() {
                //retrieve permisions
                currentUser = currentUser.getUser(email, password);
                System.out.println("got simple user priviliges");
                currentUser.fillTasks();
                System.out.println("tasks filled");

                updateCaptions();

                refreshSolutions();
                setTasksTable();

                setComponentsAvailable(true);
            }
        };
        t.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        showOrHideDoneTasks = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        solutionsList = new javax.swing.JList<>();
        btnMarkTask = new javax.swing.JButton();
        btnVote = new javax.swing.JButton();
        btnSuggestSolution = new javax.swing.JButton();
        btnLanguage = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        SimpleUserMenuPBar = new javax.swing.JProgressBar();
        btnChat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        btnMenuEditProfile = new javax.swing.JMenuItem();
        btnMenuLogout = new javax.swing.JMenuItem();
        btnMenuExit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        btnHelpAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Homework");
        setBackground(new java.awt.Color(153, 204, 255));
        setResizable(false);

        lblWelcome.setFont(new java.awt.Font("Serif", 3, 20)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome User!");
        lblWelcome.setPreferredSize(new java.awt.Dimension(154, 26));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources/uimessages_iw"); // NOI18N
        showOrHideDoneTasks.setText(bundle.getString("chbShowOrHideDoneTasks")); // NOI18N
        showOrHideDoneTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOrHideDoneTasksActionPerformed(evt);
            }
        });

        solutionsList.setBackground(new java.awt.Color(240, 240, 240));
        solutionsList.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        solutionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(solutionsList);

        btnMarkTask.setBackground(new java.awt.Color(155, 255, 155));
        btnMarkTask.setText(bundle.getString("btnMarkTaskDone")); // NOI18N
        btnMarkTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkTaskActionPerformed(evt);
            }
        });

        btnVote.setBackground(new java.awt.Color(0, 153, 153));
        btnVote.setText(bundle.getString("btnVoteVote")); // NOI18N
        btnVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoteActionPerformed(evt);
            }
        });

        btnSuggestSolution.setText(bundle.getString("btnSuggestSolutionSuggest")); // NOI18N
        btnSuggestSolution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuggestSolutionActionPerformed(evt);
            }
        });

        btnLanguage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homework/Images/LangIcon.png"))); // NOI18N
        btnLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanguageActionPerformed(evt);
            }
        });

        tasksTable.setBackground(new java.awt.Color(102, 204, 255));
        tasksTable.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Task Name", "Task Deadline", "Task Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tasksTable);

        SimpleUserMenuPBar.setIndeterminate(true);
        SimpleUserMenuPBar.setString("");

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("resources/uimessages"); // NOI18N
        btnChat.setText(bundle1.getString("btnChat")); // NOI18N
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        menuMenu.setText(bundle.getString("menuMenu")); // NOI18N

        btnMenuEditProfile.setText(bundle.getString("btnEditProfile")); // NOI18N
        btnMenuEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEditProfileActionPerformed(evt);
            }
        });
        menuMenu.add(btnMenuEditProfile);

        btnMenuLogout.setText(bundle.getString("btnLogout")); // NOI18N
        btnMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuLogoutActionPerformed(evt);
            }
        });
        menuMenu.add(btnMenuLogout);

        btnMenuExit.setText(bundle.getString("btnExit")); // NOI18N
        btnMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuExitActionPerformed(evt);
            }
        });
        menuMenu.add(btnMenuExit);

        jMenuBar1.add(menuMenu);

        menuHelp.setText(bundle.getString("menuHelp")); // NOI18N

        btnHelpAbout.setText(bundle.getString("helpAbout")); // NOI18N
        btnHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpAboutActionPerformed(evt);
            }
        });
        menuHelp.add(btnHelpAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnMarkTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnChat, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(showOrHideDoneTasks)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnVote))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addComponent(btnSuggestSolution)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(SimpleUserMenuPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(showOrHideDoneTasks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMarkTask, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChat))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnVote)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuggestSolution)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SimpleUserMenuPBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarkTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkTaskActionPerformed
        javax.swing.JFrame context = this;
        Thread t = new Thread() {
            public void run() {
                setComponentsAvailable(false);
                int taskID;
                if (parseTaskID() < 0) {
                    setComponentsAvailable(true);
                    return;
                }
                taskID = parseTaskID();
                for (Task t : currentUser.getLocalTasks()) //go through all local tasks
                {
                    if (taskID == t.getTaskID() && t.getStatus() == false) { //check if id exists and if the status is the oppesit from required action
                        t.setStatus(true);
                        currentUser.getLocalDoneTasks().add(taskID);
                        currentUser.markTask(taskID, true);
                        ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("taskMarkAsDoneSucc"), 3000);
                        toastMessage.setVisible(true);
                        setTasksTable();
                        btnMarkTask.setText(LocalizationUtil.localizedResourceBundle.getString("btnMarkTaskDone"));
                        btnMarkTask.setBackground(markGreen);
                        setComponentsAvailable(true);
                        return;
                    } else if (parseTaskID() == t.getTaskID() && t.getStatus() == true) {
                        t.setStatus(false);
                        currentUser.getLocalDoneTasks().remove(taskID);
                        currentUser.markTask(taskID, false);
                        ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("taskMarkAsUndoneSucc"), 3000);
                        toastMessage.setVisible(true);
                        setTasksTable();
                        btnMarkTask.setText(LocalizationUtil.localizedResourceBundle.getString("btnMarkTaskDone"));
                        btnMarkTask.setBackground(markGreen);
                        setComponentsAvailable(true);
                        return;
                    }
                }
                ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("chooseTaskFirst"), 3000);
                toastMessage.setVisible(true);
                setComponentsAvailable(true);
            }
        };
        t.start();
    }//GEN-LAST:event_btnMarkTaskActionPerformed

    private void btnVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoteActionPerformed
        javax.swing.JFrame context = this;
        Thread t = new Thread() {
            public void run() {
                setComponentsAvailable(false);
                String solutionEmail;
                if (parseSolutionEmail() == null) {
                    setComponentsAvailable(true);
                    return;
                }
                solutionEmail = parseSolutionEmail();
                int taskID;
                if (parseTaskID() < 0) {
                    setComponentsAvailable(true);
                    return;
                }
                taskID = parseTaskID();
                for (Task t : currentUser.getLocalTasks()) {
                    if (t.getTaskID() == taskID) {
                        for (Solution s : t.getSolutions()) {
                            if (s.getUserEmail().equals(solutionEmail)) {
                                if (!currentUser.isAlreadyVoted(s.getSolutionID())) {
                                    if (currentUser.voteSolution(s.getSolutionID())) {
                                        ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("addVoteSucc"), 3000);
                                        toastMessage.setVisible(true);
                                        refreshSolutions();
                                        setComponentsAvailable(true);
                                        return;
                                    } else {
                                        ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("addVoteFail"), 3000);
                                        toastMessage.setVisible(true);
                                        refreshSolutions();
                                        setComponentsAvailable(true);
                                        return;
                                    }
                                } else if (currentUser.unVoteSolution(s.getSolutionID())) {
                                    ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("removeVoteSucc"), 3000);
                                    toastMessage.setVisible(true);
                                    refreshSolutions();
                                    setComponentsAvailable(true);
                                    return;
                                } else {
                                    ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("removeVoteFail"), 3000);
                                    toastMessage.setVisible(true);
                                    refreshSolutions();
                                    setComponentsAvailable(true);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        };
        t.start();
    }//GEN-LAST:event_btnVoteActionPerformed

    private void btnSuggestSolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuggestSolutionActionPerformed
        javax.swing.JFrame context = this;
        Thread t = new Thread() {
            public void run() {
                setComponentsAvailable(false);
                int taskID;
                if (parseTaskID() < 0) {
                    ToastMessage toastMessage = new ToastMessage(LocalizationUtil.localizedResourceBundle.getString("chooseTaskFirst"), 3000);
                    toastMessage.setVisible(true);
                    setComponentsAvailable(true);
                    return;
                }
                taskID = parseTaskID();

                for (Task t : currentUser.getLocalTasks()) {
                    if (t.getTaskID() == taskID) {
                        if (!t.getSolutions().isEmpty()) {
                            for (Solution s : t.getSolutions()) {
                                if (s.getUserEmail().equals(currentUser.getEmail()) && s.getUserEmail().equals(parseSolutionEmail())) {
                                    EditSolutionPopUp editSolutionPopUp = new EditSolutionPopUp(s, currentUser);
                                    context.dispose();
                                    return;
                                }
                            }
                            AddNewSolutionPopUp addNewSolutionPopUp = new AddNewSolutionPopUp(currentUser, taskID);
                            context.dispose();
                            return;
                        } else {
                            AddNewSolutionPopUp addNewSolutionPopUp = new AddNewSolutionPopUp(currentUser, taskID);
                            context.dispose();
                            return;
                        }
                    }
                }
                setComponentsAvailable(true);
            }
        };
        t.start();
    }//GEN-LAST:event_btnSuggestSolutionActionPerformed

    private void showOrHideDoneTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOrHideDoneTasksActionPerformed
        //  loadTasksList();
        setTasksTable();
    }//GEN-LAST:event_showOrHideDoneTasksActionPerformed

    private void btnMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuLogoutActionPerformed
        MainScreen mainMenuTest = new MainScreen();
        this.dispose();
    }//GEN-LAST:event_btnMenuLogoutActionPerformed

    private void btnMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnMenuExitActionPerformed

    private void btnLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanguageActionPerformed

        if (Language.equals("iw")) {
            Language = "en";
        } else if (Language.equals("en")) {
            Language = "iw";
        } else {
            Language = LocalizationUtil.localizedResourceBundle.getLocale().getLanguage();
        }
        LocalizationUtil.localizedResourceBundle = ResourceBundle.getBundle("resources.uimessages", new Locale(Language));
        updateCaptions();
    }//GEN-LAST:event_btnLanguageActionPerformed

    private void btnHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpAboutActionPerformed
        AboutPopUp aboutPopUp = new AboutPopUp();
    }//GEN-LAST:event_btnHelpAboutActionPerformed

    private void btnMenuEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEditProfileActionPerformed
        javax.swing.JFrame context = this;
        Thread t = new Thread() {
            public void run() {
                setComponentsAvailable(false);
                EditProfile editProfile = new EditProfile(currentUser);
                context.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_btnMenuEditProfileActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        openChatScreen();
    }//GEN-LAST:event_btnChatActionPerformed

    private void refreshSolutions() {
        localSolutions = currentUser.getSolutions();
    }

    private void loadSolutions(int taskID) {
        HashSet<Solution> tempLocalSolutions = new HashSet<>();
        for (Task t : currentUser.getLocalTasks()) {
            tempLocalSolutions.clear();
            for (Solution s : localSolutions) {
                if (s.getTaskID() == t.getTaskID()) {
                    tempLocalSolutions.add(s);
                }
            }
            t.setSolutions(tempLocalSolutions);
        }

        solutions.clear();
        for (Task t : currentUser.getLocalTasks()) {
            if (t.getTaskID() == taskID) {  //found the relevant task
                for (Solution s : t.getSolutions()) {   //add task's solutions to solutions array
                    if (s.isApproved()) {
                        solutions.add(s.toString() + " approved");
                    } else {
                        solutions.add(s.toString());
                    }
                }
                break;
            }
        }
        //clear solutions list
        solutionsListModel.removeAllElements();
        //fill soultion list
        for (String s : solutions) {
            solutionsListModel.addElement(s);
        }

        solutionsList.setModel(solutionsListModel);
        solutionsList.setCellRenderer(this);
        solutionsList.setVisible(true);
    }

    private void setMarkTaskBtn(int taskID) {
        for (Task t : currentUser.getLocalTasks()) {
            if (t.getTaskID() == taskID) {
                if (t.getStatus() == false) {
                    btnMarkTask.setText(LocalizationUtil.localizedResourceBundle.getString("btnMarkTaskDone"));
                    btnMarkTask.setBackground(markGreen);

                } else {
                    btnMarkTask.setText(LocalizationUtil.localizedResourceBundle.getString("btnMarkTaskUndone"));
                    btnMarkTask.setBackground(markRed);
                }
                return;
            }
        }
    }

    private void setSuggestSolutionBtn(int taskID) {
        if (!solutionsList.isSelectionEmpty()) {    //if solution is selected
            String solutionEmail;
            if (parseSolutionEmail() == null) {
                return;
            }
            solutionEmail = parseSolutionEmail();
            btnSuggestSolution.setVisible(true);
            btnSuggestSolution.setEnabled(true);
            for (Task t : currentUser.getLocalTasks()) {
                if (t.getTaskID() == taskID) {
                    for (Solution s : t.getSolutions()) {
                        if (s.getUserEmail().equals(currentUser.getEmail()) && s.getUserEmail().equals(solutionEmail)) {      //user solution
                            btnSuggestSolution.setText(LocalizationUtil.localizedResourceBundle.getString("btnSuggestSolutionEdit"));
                            btnSuggestSolution.setVisible(true);
                            btnSuggestSolution.setEnabled(true);
                            return;
                        } else {                                                                                                                                //NOT user solution
                            btnSuggestSolution.setText(LocalizationUtil.localizedResourceBundle.getString("btnSuggestSolutionSuggest"));
                            btnSuggestSolution.setVisible(false);
                            btnSuggestSolution.setEnabled(true);

                        }

                    }
                }
            }
        } else {                                              //if task is selected
            btnSuggestSolution.setVisible(true);
            btnSuggestSolution.setEnabled(true);
            btnSuggestSolution.setText(LocalizationUtil.localizedResourceBundle.getString("btnSuggestSolutionSuggest"));
            for (Task t : currentUser.getLocalTasks()) {
                if (t.getTaskID() == taskID) {
                    for (Solution s : t.getSolutions()) {
                        if (s.getUserEmail().equals(currentUser.getEmail())) {                                                             //has user solution
                            btnSuggestSolution.setText(LocalizationUtil.localizedResourceBundle.getString("btnSuggestSolutionEdit"));
                            btnSuggestSolution.setVisible(false);
                            btnSuggestSolution.setEnabled(false);
                            return;

                        } else {                                                                                                                 //Doesn't have user solution
                            btnSuggestSolution.setEnabled(true);
                        }

                    }
                }
            }
        }
    }

    private void setVoteBtn(int taskID) {
        for (Task t : currentUser.getLocalTasks()) {
            if (t.getTaskID() == taskID) {
                for (Solution s : t.getSolutions()) {
                    if (!currentUser.isAlreadyVoted(s.getSolutionID())) {
                        btnVote.setText(LocalizationUtil.localizedResourceBundle.getString("btnVoteVote"));
                        btnVote.setBackground(voteBlue);
                    } else {
                        btnVote.setText(LocalizationUtil.localizedResourceBundle.getString("btnVoteUnvote"));
                        btnVote.setBackground(voteRed);
                    }
                }
            }
        }
    }

    private int parseTaskID() {
        int taskID = -1;
        int selectedRow = tasksTable.getSelectedRow();
        if (selectedRow >= 0) {
            taskID = Integer.valueOf(tasksTable.getValueAt(selectedRow, 0).toString());
        }
        return taskID;
    }

    private String parseSolutionEmail() {
        if (solutionsList.getSelectedValue() != null) {
            return solutionsList.getSelectedValue().split(": ")[1];
        }
        return null;
    }

    private void updateCaptions() {
        setTitle(LocalizationUtil.localizedResourceBundle.getString("userMenuKey"));
        lblWelcome.setText(LocalizationUtil.localizedResourceBundle.getString("lblWelcome") + currentUser.getUsername());
        btnMarkTask.setText(LocalizationUtil.localizedResourceBundle.getString("btnMarkTaskDone"));
        btnChat.setText(LocalizationUtil.localizedResourceBundle.getString("btnChat"));
        menuMenu.setText(LocalizationUtil.localizedResourceBundle.getString("menuMenu"));
        btnMenuExit.setText(LocalizationUtil.localizedResourceBundle.getString("btnExit"));
        menuHelp.setText(LocalizationUtil.localizedResourceBundle.getString("menuHelp"));
        btnHelpAbout.setText(LocalizationUtil.localizedResourceBundle.getString("helpAbout"));
        btnMenuLogout.setText(LocalizationUtil.localizedResourceBundle.getString("btnLogout"));
        btnMenuEditProfile.setText(LocalizationUtil.localizedResourceBundle.getString("btnEditProfile"));
        btnVote.setText(LocalizationUtil.localizedResourceBundle.getString("btnVoteVote"));
        btnSuggestSolution.setText(LocalizationUtil.localizedResourceBundle.getString("btnSuggestSolutionSuggest"));
        showOrHideDoneTasks.setText(LocalizationUtil.localizedResourceBundle.getString("chbShowOrHideDoneTasks"));
        tasksTable.getColumnModel().getColumn(0).setHeaderValue(LocalizationUtil.localizedResourceBundle.getString("lblTaskTableC1"));
        tasksTable.getColumnModel().getColumn(1).setHeaderValue(LocalizationUtil.localizedResourceBundle.getString("lblTaskTableC2"));
        tasksTable.getColumnModel().getColumn(2).setHeaderValue(LocalizationUtil.localizedResourceBundle.getString("lblTaskTableC3"));
        tasksTable.getColumnModel().getColumn(3).setHeaderValue(LocalizationUtil.localizedResourceBundle.getString("lblTaskTableC4"));
    }

    private void setTasksTable() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

        //clear all rows
        for (int i = 0; i < tasksTable.getRowCount(); i++) {
            ((DefaultTableModel) tasksTable.getModel()).removeRow(i);
        }

        DefaultTableModel dtm = (DefaultTableModel) tasksTable.getModel();

        int taskIndex = 0;
        if (showOrHideDoneTasks.isSelected()) {     //show all tasks
            //set amount of rows
            dtm.setRowCount(currentUser.getLocalTasks().size());
            //fill table rows
            for (Task t : currentUser.getLocalTasks()) {
                for (int i = 0; i < 4; i++) {
                    if (i == 0) {
                        tasksTable.setValueAt(t.getTaskID(), taskIndex, i);
                    } else if (i == 1) {
                        tasksTable.setValueAt(t.getTaskName(), taskIndex, i);
                    } else if (i == 2) {
                        tasksTable.setValueAt(formater.format(t.getDeadline()), taskIndex, i);
                    } else if (i == 3) {
                        tasksTable.setValueAt(t.getStatus(), taskIndex, i);
                    }
                }
                taskIndex++;
            }
        } else {     //show not-done tasks 
            //get the number of not-done tasks
            int amountOfNotDoneTasks = 0;
            for (Task t : currentUser.getLocalTasks()) {
                if (!t.getStatus()) {
                    amountOfNotDoneTasks++;
                }
            }
            //set amount of rows
            dtm.setRowCount(amountOfNotDoneTasks);
            //fill table rows
            for (Task t : currentUser.getLocalTasks()) {
                if (!t.getStatus()) {
                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            tasksTable.setValueAt(t.getTaskID(), taskIndex, i);
                        } else if (i == 1) {
                            tasksTable.setValueAt(t.getTaskName(), taskIndex, i);
                        } else if (i == 2) {
                            tasksTable.setValueAt(formater.format(t.getDeadline()), taskIndex, i);
                        } else if (i == 3) {
                            tasksTable.setValueAt(t.getStatus(), taskIndex, i);
                        }
                    }
                } else {
                    taskIndex--;
                }
                taskIndex++;
            }
        }

        tasksTable.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tasksTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int taskID = -1;
                String selectedData = null;

                int[] selectedRow = tasksTable.getSelectedRows();
                int[] selectedColumns = tasksTable.getSelectedColumns();

                for (int i = 0; i < selectedRow.length; i++) {
                    for (int j = 0; j < selectedColumns.length; j++) {
                        selectedData = tasksTable.getValueAt(selectedRow[i], selectedColumns[j]).toString();
                        if (parseTaskID() < 0) {
                            return;
                        }
                        taskID = parseTaskID();
                    }
                }
                System.out.println("Selected: " + selectedData);

                btnVote.setVisible(false);
                btnSuggestSolution.setVisible(false);

                //Load Solutions
                loadSolutions(taskID);
                //Set Suggest Solution Button
                setSuggestSolutionBtn(taskID);

                //Set Mark Task Button
                setMarkTaskBtn(taskID);
            }
        });
        TasksTableRenderer myRenderer = new TasksTableRenderer();
        tasksTable.setDefaultRenderer(Object.class, myRenderer);
    }

    private void setComponentsAvailable(boolean available) {
        SimpleUserMenuPBar.setVisible(!available);
        btnMenuLogout.setEnabled(available);
        tasksTable.setEnabled(available);
        btnMarkTask.setEnabled(available);
        showOrHideDoneTasks.setEnabled(available);
        btnChat.setEnabled(available);
        btnLanguage.setEnabled(available);
        btnHelpAbout.setEnabled(available);
        btnMenuEditProfile.setEnabled(available);
    }

    private void openChatScreen() {
        Thread t = new Thread() {
            public void run() {
                try {
                     ChatScreen simpleToAdminChat = new ChatScreen(currentUser);
                   // ChatClient.main(currentUser);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        t.start();

    }

    public static void main(String email, String password) {
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
            java.util.logging.Logger.getLogger(SimpleUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleUserMenu(email, password).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar SimpleUserMenuPBar;
    private javax.swing.JButton btnChat;
    private javax.swing.JMenuItem btnHelpAbout;
    private javax.swing.JButton btnLanguage;
    private javax.swing.JButton btnMarkTask;
    private javax.swing.JMenuItem btnMenuEditProfile;
    private javax.swing.JMenuItem btnMenuExit;
    private javax.swing.JMenuItem btnMenuLogout;
    private javax.swing.JButton btnSuggestSolution;
    private javax.swing.JButton btnVote;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    protected javax.swing.JLabel lblWelcome;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuMenu;
    protected javax.swing.JCheckBox showOrHideDoneTasks;
    private javax.swing.JList<String> solutionsList;
    private javax.swing.JTable tasksTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //add email to tooltip
        JLabel solutionRow;
        solutionRow = new JLabel();
        solutionRow.setFont(new java.awt.Font("Arial", 3, 14));
        solutionRow.setOpaque(true);
        if (isSelected) {
            solutionRow.setBackground(list.getSelectionBackground());
        } else {
            solutionRow.setBackground(list.getBackground());
        }
        if (value.toString().endsWith(" approved")) {
            solutionRow.setForeground(approvedColor);
            solutionRow.setText(value.toString().split(" approved")[0]);
        } else {
            solutionRow.setText(value.toString());
            solutionRow.setForeground(Color.BLACK);
        }
        if (Language.equals("iw")) {
            solutionRow.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        } else {
            solutionRow.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }
        return solutionRow;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (e.getSource() == solutionsList) {
                btnSuggestSolution.setEnabled(false);

                String solutionEmail;
                if (parseSolutionEmail() == null) {
                    return;
                }
                //get Email from the list string
                solutionEmail = parseSolutionEmail();

                int taskID;
                if (parseTaskID() < 0) {
                    return;
                }

                //get TaskID from the list string
                taskID = parseTaskID();

                //Set Suggest Solution Button
                setSuggestSolutionBtn(taskID);

                btnVote.setVisible(true);
                setVoteBtn(taskID);

                if (solutionEmail.equals(currentUser.getEmail())) {
                    btnVote.setEnabled(false);
                    return;
                }

                btnVote.setEnabled(true);

            }
        }
    }

}
