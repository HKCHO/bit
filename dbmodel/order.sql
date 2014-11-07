-- ��ǰ����
DROP TABLE IF EXISTS PROBUCTS RESTRICT;

-- ��ǰ����
DROP TABLE IF EXISTS PROD_PHOTS RESTRICT;

-- �ּ�����
DROP TABLE IF EXISTS ADDRS RESTRICT;

-- �ֹ�������
DROP TABLE IF EXISTS MEMBERS RESTRICT;

-- ������
DROP TABLE IF EXISTS MAKERS RESTRICT;

-- �ֹ�����
DROP TABLE IF EXISTS DRDERS RESTRICT;

-- ��ǰ����
CREATE TABLE PROBUCTS (
	PNO   INTEGER      NOT NULL COMMENT '��ǰ��ȣ', -- ��ǰ��ȣ
	PNAME VARCHAR(255) NOT NULL COMMENT '��ǰ��', -- ��ǰ��
	QTY   INTEGER      NOT NULL COMMENT '�ܿ�����', -- �ܿ�����
	MKNO  INTEGER      NULL     COMMENT '������ ��ȣ' -- ������ ��ȣ
)
COMMENT '��ǰ����';

-- ��ǰ����
ALTER TABLE PROBUCTS
	ADD CONSTRAINT PK_PROBUCTS -- ��ǰ���� �⺻Ű
		PRIMARY KEY (
			PNO -- ��ǰ��ȣ
		);

-- ��ǰ���� �ε���
CREATE INDEX IX_PROBUCTS
	ON PROBUCTS( -- ��ǰ����
		PNAME ASC -- ��ǰ��
	);

ALTER TABLE PROBUCTS
	MODIFY COLUMN PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ǰ��ȣ';

-- ��ǰ����
CREATE TABLE PROD_PHOTS (
	COL6 INTEGER      NOT NULL COMMENT '��ǰ������ȣ', -- ��ǰ������ȣ
	PNO  INTEGER      NULL     COMMENT '��ǰ��ȣ', -- ��ǰ��ȣ
	URL  VARCHAR(255) NULL     COMMENT '��ǰ�������' -- ��ǰ�������
)
COMMENT '��ǰ����';

-- ��ǰ����
ALTER TABLE PROD_PHOTS
	ADD CONSTRAINT PK_PROD_PHOTS -- ��ǰ���� �⺻Ű
		PRIMARY KEY (
			COL6 -- ��ǰ������ȣ
		);

ALTER TABLE PROD_PHOTS
	MODIFY COLUMN COL6 INTEGER NOT NULL AUTO_INCREMENT COMMENT '��ǰ������ȣ';

-- �ּ�����
CREATE TABLE ADDRS (
	ANO       INTEGER      NOT NULL COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	POSTNO    VARCHAR(10)  NOT NULL COMMENT '�����ȣ', -- �����ȣ
	BASS_ADDR VARCHAR(255) NOT NULL COMMENT '�⺻�ּ�' -- �⺻�ּ�
)
COMMENT '�ּ�����';

-- �ּ�����
ALTER TABLE ADDRS
	ADD CONSTRAINT PK_ADDRS -- �ּ����� �⺻Ű
		PRIMARY KEY (
			ANO -- �ּҹ�ȣ
		);

ALTER TABLE ADDRS
	MODIFY COLUMN ANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ּҹ�ȣ';

-- �ֹ�������
CREATE TABLE MEMBERS (
	UID      VARCHAR(20)  NOT NULL COMMENT '���̵�', -- ���̵�
	EMAIL    VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	PWD      VARCHAR(20)  NOT NULL COMMENT '��ȣ', -- ��ȣ
	UNAME    VARCHAR(80)  NOT NULL COMMENT '�ֹ��ڸ�', -- �ֹ��ڸ�
	TEL      VARCHAR(30)  NULL     COMMENT '��ȭ', -- ��ȭ
	FAX      VARCHAR(30)  NULL     COMMENT '�ѽ�', -- �ѽ�
	DTE_ADDR VARCHAR(255) NULL     COMMENT '���ּ�', -- ���ּ�
	PHOT     VARCHAR(255) NULL     COMMENT '�ֹ��ڻ���', -- �ֹ��ڻ���
	ANO      INTEGER      NULL     COMMENT '�ּҹ�ȣ' -- �ּҹ�ȣ
)
COMMENT '�ֹ�������';

-- �ֹ�������
ALTER TABLE MEMBERS
	ADD CONSTRAINT PK_MEMBERS -- �ֹ������� �⺻Ű
		PRIMARY KEY (
			UID -- ���̵�
		);

-- �ֹ������� ����ũ �ε���
CREATE UNIQUE INDEX UIX_MEMBERS
	ON MEMBERS ( -- �ֹ�������
		EMAIL ASC -- �̸���
	);

-- �ֹ������� �ε���
CREATE INDEX IX_MEMBERS
	ON MEMBERS( -- �ֹ�������
		UNAME ASC -- �ֹ��ڸ�
	);

-- ������
CREATE TABLE MAKERS (
	MKNO   INTEGER      NOT NULL COMMENT '������ ��ȣ', -- ������ ��ȣ
	NKNAME VARCHAR(80)  NOT NULL COMMENT '������', -- ������
	HOME   VARCHAR(255) NULL     COMMENT '������Ȩ������', -- ������Ȩ������
	TEL    VARCHAR(30)  NULL     COMMENT '��������ȭ', -- ��������ȭ
	FAX    VARCHAR(30)  NULL     COMMENT '�������ѽ�' -- �������ѽ�
)
COMMENT '������';

-- ������
ALTER TABLE MAKERS
	ADD CONSTRAINT PK_MAKERS -- ������ �⺻Ű
		PRIMARY KEY (
			MKNO -- ������ ��ȣ
		);

ALTER TABLE MAKERS
	MODIFY COLUMN MKNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ ��ȣ';

-- �ֹ�����
CREATE TABLE DRDERS (
	ONO   INTEGER     NOT NULL COMMENT '�ֹ���ȣ', -- �ֹ���ȣ
	QTR   INTEGER     NOT NULL COMMENT '�ֹ�����', -- �ֹ�����
	ODATE DATE        NOT NULL COMMENT '�ֹ���', -- �ֹ���
	PNO   INTEGER     NOT NULL COMMENT '��ǰ��ȣ', -- ��ǰ��ȣ
	UID   VARCHAR(20) NOT NULL COMMENT '���̵�' -- ���̵�
)
COMMENT '�ֹ�����';

-- �ֹ�����
ALTER TABLE DRDERS
	ADD CONSTRAINT PK_DRDERS -- �ֹ����� �⺻Ű
		PRIMARY KEY (
			ONO -- �ֹ���ȣ
		);

ALTER TABLE DRDERS
	MODIFY COLUMN ONO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ֹ���ȣ';

ALTER TABLE DRDERS
	AUTO_INCREMENT = 0;

-- ��ǰ����
ALTER TABLE PROBUCTS
	ADD CONSTRAINT FK_MAKERS_TO_PROBUCTS -- ������ -> ��ǰ����
		FOREIGN KEY (
			MKNO -- ������ ��ȣ
		)
		REFERENCES MAKERS ( -- ������
			MKNO -- ������ ��ȣ
		);

-- ��ǰ����
ALTER TABLE PROD_PHOTS
	ADD CONSTRAINT FK_PROBUCTS_TO_PROD_PHOTS -- ��ǰ���� -> ��ǰ����
		FOREIGN KEY (
			PNO -- ��ǰ��ȣ
		)
		REFERENCES PROBUCTS ( -- ��ǰ����
			PNO -- ��ǰ��ȣ
		);

-- �ֹ�������
ALTER TABLE MEMBERS
	ADD CONSTRAINT FK_ADDRS_TO_MEMBERS -- �ּ����� -> �ֹ�������
		FOREIGN KEY (
			ANO -- �ּҹ�ȣ
		)
		REFERENCES ADDRS ( -- �ּ�����
			ANO -- �ּҹ�ȣ
		);

-- �ֹ�����
ALTER TABLE DRDERS
	ADD CONSTRAINT FK_PROBUCTS_TO_DRDERS -- ��ǰ���� -> �ֹ�����
		FOREIGN KEY (
			PNO -- ��ǰ��ȣ
		)
		REFERENCES PROBUCTS ( -- ��ǰ����
			PNO -- ��ǰ��ȣ
		);

-- �ֹ�����
ALTER TABLE DRDERS
	ADD CONSTRAINT FK_MEMBERS_TO_DRDERS -- �ֹ������� -> �ֹ�����
		FOREIGN KEY (
			UID -- ���̵�
		)
		REFERENCES MEMBERS ( -- �ֹ�������
			UID -- ���̵�
		);