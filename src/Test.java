public class Test {
    public class Student implements Comparable<Student> {
        private  int stuId;
        private String stuName;
        private int score;

        public Student(int stuId, String stuName, int score) {
            this.stuId = stuId;
            this.stuName = stuName;
            this.score = score;
        }

        public int getStuId() {
            return stuId;
        }

        public void setStuId(int stuId) {
            this.stuId = stuId;
        }

        public String getStuName() {
            return stuName;
        }

        public void setStuName(String stuName) {
            this.stuName = stuName;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score-score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuId=" + stuId +
                    ", stuName='" + stuName + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

}
