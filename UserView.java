package cs356_twitter;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author donov
 */
public class UserView extends javax.swing.JFrame {

    private User thisUser;
    private TwitterAdmin instance = TwitterAdmin.getInstance();
    
    public UserView(User input) {
        initComponents();
        thisUser = input;
        this.setTitle(input.toString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        FollowUserID = new javax.swing.JTextField();
        FollowUser = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TweetMessage = new javax.swing.JTextArea();
        PostTweet = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        NewsFeed = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Subscriptions = new javax.swing.JTextArea();

        FollowUserID.setText("User ID");
        jSplitPane2.setLeftComponent(FollowUserID);

        FollowUser.setText("Follow User");
        FollowUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FollowUserActionPerformed(evt);
            }
        });
        jSplitPane2.setRightComponent(FollowUser);

        TweetMessage.setColumns(20);
        TweetMessage.setRows(5);
        TweetMessage.setToolTipText("Type your tweet message here: ");
        jScrollPane2.setViewportView(TweetMessage);

        PostTweet.setText("Post Tweet");
        PostTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostTweetActionPerformed(evt);
            }
        });

        NewsFeed.setEditable(false);
        NewsFeed.setColumns(20);
        NewsFeed.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        NewsFeed.setLineWrap(true);
        NewsFeed.setRows(5);
        NewsFeed.setText("News Feed: \n");
        NewsFeed.setToolTipText("");
        jScrollPane4.setViewportView(NewsFeed);

        Subscriptions.setColumns(20);
        Subscriptions.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        Subscriptions.setRows(5);
        Subscriptions.setText("Currently Following: ");
        jScrollPane3.setViewportView(Subscriptions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostTweet, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PostTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FollowUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FollowUserActionPerformed
        User follow = instance.getUser(FollowUserID.getText()); // follow = null ID doesn't match anyone
        
        if(follow != null) {
           boolean successful = thisUser.addSubscription(follow);
           if (successful) 
                Subscriptions.append("\n" + follow.getID());
        } else {
            System.out.println("There is no user with this ID.");
        }
    }//GEN-LAST:event_FollowUserActionPerformed

    private void PostTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostTweetActionPerformed
        thisUser.newTweet(TweetMessage.getText());
    }//GEN-LAST:event_PostTweetActionPerformed
    
    public void updateNewsFeed(String feed) {
       NewsFeed.append(feed);
    }
    
    /**
     * @param args the command line arguments
     */
 /*   public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
  /*      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView(thisUser).setVisible(true);
            }
        }); 
   }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FollowUser;
    private javax.swing.JTextField FollowUserID;
    private javax.swing.JTextArea NewsFeed;
    private javax.swing.JButton PostTweet;
    private javax.swing.JTextArea Subscriptions;
    private javax.swing.JTextArea TweetMessage;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    // End of variables declaration//GEN-END:variables
}
