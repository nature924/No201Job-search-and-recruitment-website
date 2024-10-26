package cn.jia.common;

public class BusiRespCode {
	
	public enum Department{
		ADD_SUCCESS("100","公司添加成功"),
		ADD_FAIL("101","公司添加失败"),
		DELETE_SUCCESS("200","公司添加成功"),
		DELETE_FAIL("201","公司添加失败"),
		UPDATE_SUCCESS("300","公司添加成功"),
		UPDATE_FAIL("301","公司添加失败");
		private String code;
		private String msg;
		private Department(String code,String msg) {
			this.code = code;
			this.msg = msg;
		}
		public String getCode() {
			return code;
		}
		public String getMsg() {
			return msg;
		}
	}
	
	public enum Job{
		ADD_SUCCESS("100","职位添加成功"),
		ADD_FAIL("101","职位添加失败"),
		DELETE_SUCCESS("200","职位添加成功"),
		DELETE_FAIL("201","职位添加失败"),
		UPDATE_SUCCESS("300","职位添加成功"),
		UPDATE_FAIL("301","职位添加失败");
		private String code;
		private String msg;
		private Job(String code,String msg) {
			this.code = code;
			this.msg = msg;
		}
		public String getCode() {
			return code;
		}
		public String getMsg() {
			return msg;
		}
	}
	
}
