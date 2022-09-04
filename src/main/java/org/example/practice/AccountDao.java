package org.example.practice;

public interface AccountDao {

    /**
     * userIdを指定し、アカウント情報を取得する。
     * @param userId システムで一意であるユーザID
     * @return 指定されたユーザIDのアカウント情報、存在しない場合はNull
     */
    Account findOrNull(String userId);
}
