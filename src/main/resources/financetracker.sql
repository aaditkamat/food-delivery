CREATE TABLE USER (
    user_id UUID NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(30) NOT NULL,
    date_joined TIMESTAMP(6) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE ACCOUNT (
    account_id UUID NOT NULL,
    account_name VARCHAR(30) NOT NULL,
    initial_bal FLOAT NOT NULL,
    created_date DATETIME NOT NULL
);

CREATE TABLE REPORT (
     report_id UUID NOT NULL,
     date_generated DATETIME NOT NULL,
     type VARCHAR(20) NOT NULL,
     report_desc VARCHAR(50) NOT NULL
);

CREATE TABLE INCOME (
       income_id UUID NOT NULL,
       income_title VARCHAR(30) NOT NULL,
       date DATETIME NOT NULL,
       description VARCHAR(30) NOT NULL,
       income_amount FLOAT NOT NULL
       FOREIGN KEY (user_id) REFERENCES USER (user_id),
       FOREIGN KEY (report_id) REFERENCES REPORT(report_id),
       PRIMARY KEY (user_id, report_id)
);

CREATE TABLE EXPENSE (
       expense_id UUID NOT NULL,
       expense_amount FLOAT NOT NULL,
       description VARCHAR(30) NOT NULL,
       date DATETIME NOT NULL,
       expense_title VARCHAR(30) NOT NULL
       FOREIGN KEY (user_id) REFERENCES USER (user_id),
       FOREIGN KEY (report_id) REFERENCES REPORT(report_id),
       PRIMARY KEY (user_id, report_id)
);


CREATE TABLE CATEGORIES (
       category_id UUID NOT NULL,
       category_name VARCHAR(30) NOT NULL,
);

-- Relationships
CREATE TABLE GENERATES (
       user_id UUID NOT NULL,
       report_id UUID NOT NULL,
       FOREIGN KEY (user_id) REFERENCES USER (user_id),
       FOREIGN KEY (report_id) REFERENCES REPORT(report_id),
       PRIMARY KEY (user_id, report_id)
);

CREATE TABLE CREATES (
       user_id UUID NOT NULL,
       account_id UUID NOT NULL,
       FOREIGN KEY (user_id) REFERENCES USER (user_id),
       FOREIGN KEY (account_id) REFERENCES ACCOUNT (account_id),
       PRIMARY KEY (user_id, account_id)
);

CREATE TABLE HAS_EXPENSE (
      account_id UUID NOT NULL,
     expense_id UUID NOT NULL,
     FOREIGN KEY (expense_id) REFERENCES EXPENSE(expense_id),
     FOREIGN KEY (account_id) REFERENCES ACCOUNT (account_id),
     PRIMARY KEY (expense_id, account_id)
);

CREATE TABLE HAS_INCOME (
     income_id UUID NOT NULL,
     account_id UUID NOT NULL,
     FOREIGN KEY (income_id) REFERENCES INCOME(income_id),
     FOREIGN KEY (account_id) REFERENCES ACCOUNT (account_id),
     PRIMARY KEY (account_id, income_id)
);

CREATE TABLE HAS_INCOME_CATEGORIES (
    income_id UUID NOT NULL,
    category_id UUID NOT NULL,
    FOREIGN KEY (income_id) REFERENCES INCOME(income_id),
    FOREIGN KEY (category_id) REFERENCES CATEGORIES (category_id),
    PRIMARY KEY (income_id, category_id)
);

CREATE TABLE HAS_EXPENSE_CATEGORIES (
   expense_id UUID NOT NULL,
   category_id UUID NOT NULL,
   FOREIGN KEY (expense_id) REFERENCES EXPENSE(expense_id),
   FOREIGN KEY (category_id) REFERENCES CATEGORIES (category_id),
   PRIMARY KEY (expense_id, category_id)
);
