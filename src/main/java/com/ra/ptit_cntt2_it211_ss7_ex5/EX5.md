Chi tiết vai trò từng tầng:
Tầng Controller (Giao diện API): Đóng vai trò cửa ngõ. Tiếp nhận dữ liệu từ Client, không xử lý bất kỳ logic kiểm tra hay tính toán nào, chỉ chuyển tiếp dữ liệu xuống tầng Service.

Tầng AOP Aspect (Bộ tiền lọc bảo mật & rủi ro): Đóng vai trò "Hải quan". Âm thầm đứng trước tầng Service để thực hiện tất cả các tác vụ phụ (Cross-cutting Concerns) bao gồm: Kiểm tra định dạng dữ liệu (bẫy dữ liệu đầu vào), đánh giá mức độ rủi ro dựa trên giá trị giao dịch, và ghi log hệ thống.

Tầng Service (Lõi nghiệp vụ): Đóng vai trò "Kho tiền". Chỉ chứa đúng một nhiệm vụ duy nhất: Thực thi cập nhật số dư hoặc ghi nhận giao dịch vào Cơ sở dữ liệu khi dữ liệu đã được tầng AOP đảm bảo là sạch và an toàn.

Global Exception Handler (Bộ gom lỗi tập trung): Trạm xử lý khủng hoảng. Đứng ở ngoài cùng để hứng mọi ngoại lệ từ tất cả các tầng, định dạng lại thành JSON chuẩn để phản hồi cho Client.