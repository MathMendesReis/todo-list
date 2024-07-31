package dev.reis.todo.list.domain.task.dto;

public class UpdateTaskDTO {
        private String title;
        private String content;

        public UpdateTaskDTO() {

        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

}
