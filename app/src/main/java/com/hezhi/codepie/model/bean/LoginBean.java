package com.hezhi.codepie.model.bean;

import java.io.Serializable;

/**
 * Created by yf11 on 2017/5/2.
 */

public class LoginBean implements Serializable {

    /**
     * desc : {"gradeID":3,"jsessionid":"64b32fcf-51a9-4103-80af-9ed1b8d53af8","mail":"","year":"2014","hxPassword":"lOxfrU","vipPayFlag":"0","idCard":"","telbinded":1,"className":"17","hxUsername":"pa72784cdd88d470d802060151355e05b","payStyle":0,"userID":917576,"schoolname":"测试三中","realname":"姜冬雪","head":"/r/user/917576/head/s150.jpg","schoolID":8291,"PayFlag":"0","tel":"18844195641","bkznUser":1,"vip":{"lkpmFlag":0,"cjqsFlag":0,"rxlxFlag":0,"sjjFlag":0,"gfzwFlag":0,"brxkFlag":0,"ndwzFlag":0,"dtzdFlag":0,"ctbFlag":0,"xxzdFlag":0,"brdFlag":0,"xbdaFlag":0},"username":"cssz14","stageID":1}
     * result : 1
     */

    private DescBean desc;
    private String result;

    public DescBean getDesc() {
        return desc;
    }

    public void setDesc(DescBean desc) {
        this.desc = desc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class DescBean {
        /**
         * gradeID : 3
         * jsessionid : 64b32fcf-51a9-4103-80af-9ed1b8d53af8
         * mail :
         * year : 2014
         * hxPassword : lOxfrU
         * vipPayFlag : 0
         * idCard :
         * telbinded : 1
         * className : 17
         * hxUsername : pa72784cdd88d470d802060151355e05b
         * payStyle : 0
         * userID : 917576
         * schoolname : 测试三中
         * realname : 姜冬雪
         * head : /r/user/917576/head/s150.jpg
         * schoolID : 8291
         * PayFlag : 0
         * tel : 18844195641
         * bkznUser : 1
         * vip : {"lkpmFlag":0,"cjqsFlag":0,"rxlxFlag":0,"sjjFlag":0,"gfzwFlag":0,"brxkFlag":0,"ndwzFlag":0,"dtzdFlag":0,"ctbFlag":0,"xxzdFlag":0,"brdFlag":0,"xbdaFlag":0}
         * username : cssz14
         * stageID : 1
         */

        private int gradeID;
        private String jsessionid;
        private String mail;
        private String year;
        private String hxPassword;
        private String vipPayFlag;
        private String idCard;
        private int telbinded;
        private String className;
        private String hxUsername;
        private int payStyle;
        private int userID;
        private String schoolname;
        private String realname;
        private String head;
        private int schoolID;
        private String PayFlag;
        private String tel;
        private int bkznUser;
        private VipBean vip;
        private String username;
        private int stageID;

        public int getGradeID() {
            return gradeID;
        }

        public void setGradeID(int gradeID) {
            this.gradeID = gradeID;
        }

        public String getJsessionid() {
            return jsessionid;
        }

        public void setJsessionid(String jsessionid) {
            this.jsessionid = jsessionid;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getHxPassword() {
            return hxPassword;
        }

        public void setHxPassword(String hxPassword) {
            this.hxPassword = hxPassword;
        }

        public String getVipPayFlag() {
            return vipPayFlag;
        }

        public void setVipPayFlag(String vipPayFlag) {
            this.vipPayFlag = vipPayFlag;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getTelbinded() {
            return telbinded;
        }

        public void setTelbinded(int telbinded) {
            this.telbinded = telbinded;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getHxUsername() {
            return hxUsername;
        }

        public void setHxUsername(String hxUsername) {
            this.hxUsername = hxUsername;
        }

        public int getPayStyle() {
            return payStyle;
        }

        public void setPayStyle(int payStyle) {
            this.payStyle = payStyle;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getSchoolname() {
            return schoolname;
        }

        public void setSchoolname(String schoolname) {
            this.schoolname = schoolname;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getSchoolID() {
            return schoolID;
        }

        public void setSchoolID(int schoolID) {
            this.schoolID = schoolID;
        }

        public String getPayFlag() {
            return PayFlag;
        }

        public void setPayFlag(String PayFlag) {
            this.PayFlag = PayFlag;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getBkznUser() {
            return bkznUser;
        }

        public void setBkznUser(int bkznUser) {
            this.bkznUser = bkznUser;
        }

        public VipBean getVip() {
            return vip;
        }

        public void setVip(VipBean vip) {
            this.vip = vip;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getStageID() {
            return stageID;
        }

        public void setStageID(int stageID) {
            this.stageID = stageID;
        }

        public static class VipBean {
            /**
             * lkpmFlag : 0
             * cjqsFlag : 0
             * rxlxFlag : 0
             * sjjFlag : 0
             *
             *
             * gfzwFlag : 0
             * brxkFlag : 0
             * ndwzFlag : 0
             * dtzdFlag : 0
             * ctbFlag : 0
             * xxzdFlag : 0
             * brdFlag : 0
             * xbdaFlag : 0
             */

            private int lkpmFlag;
            private int cjqsFlag;
            private int rxlxFlag;
            private int sjjFlag;
            private int gfzwFlag;
            private int brxkFlag;
            private int ndwzFlag;
            private int dtzdFlag;
            private int ctbFlag;
            private int xxzdFlag;
            private int brdFlag;
            private int xbdaFlag;

            public int getLkpmFlag() {
                return lkpmFlag;
            }

            public void setLkpmFlag(int lkpmFlag) {
                this.lkpmFlag = lkpmFlag;
            }

            public int getCjqsFlag() {
                return cjqsFlag;
            }

            public void setCjqsFlag(int cjqsFlag) {
                this.cjqsFlag = cjqsFlag;
            }

            public int getRxlxFlag() {
                return rxlxFlag;
            }

            public void setRxlxFlag(int rxlxFlag) {
                this.rxlxFlag = rxlxFlag;
            }

            public int getSjjFlag() {
                return sjjFlag;
            }

            public void setSjjFlag(int sjjFlag) {
                this.sjjFlag = sjjFlag;
            }

            public int getGfzwFlag() {
                return gfzwFlag;
            }

            public void setGfzwFlag(int gfzwFlag) {
                this.gfzwFlag = gfzwFlag;
            }

            public int getBrxkFlag() {
                return brxkFlag;
            }

            public void setBrxkFlag(int brxkFlag) {
                this.brxkFlag = brxkFlag;
            }

            public int getNdwzFlag() {
                return ndwzFlag;
            }

            public void setNdwzFlag(int ndwzFlag) {
                this.ndwzFlag = ndwzFlag;
            }

            public int getDtzdFlag() {
                return dtzdFlag;
            }

            public void setDtzdFlag(int dtzdFlag) {
                this.dtzdFlag = dtzdFlag;
            }

            public int getCtbFlag() {
                return ctbFlag;
            }

            public void setCtbFlag(int ctbFlag) {
                this.ctbFlag = ctbFlag;
            }

            public int getXxzdFlag() {
                return xxzdFlag;
            }

            public void setXxzdFlag(int xxzdFlag) {
                this.xxzdFlag = xxzdFlag;
            }

            public int getBrdFlag() {
                return brdFlag;
            }

            public void setBrdFlag(int brdFlag) {
                this.brdFlag = brdFlag;
            }

            public int getXbdaFlag() {
                return xbdaFlag;
            }

            public void setXbdaFlag(int xbdaFlag) {
                this.xbdaFlag = xbdaFlag;
            }
        }
    }
}
