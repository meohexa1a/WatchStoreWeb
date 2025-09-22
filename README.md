# Hướng dẫn Setup Project

## 1. Cài đặt & thêm Tomcat Server

1. Mở **Preferences**
   `Alt + W + P` → **Window > Preferences...**
   → Vào mục **Server > Runtime Environments**

   ![Runtime Env](https://github.com/user-attachments/assets/c9450435-8d1d-4229-b639-c1145651b91e)

2. Thêm Tomcat Server

   * Nhấn **Add** → Chọn **Apache > Tomcat** phiên bản phù hợp
   * Làm theo hướng dẫn (cài đặt khá đơn giản, không đi sâu ở đây)

   ![Add Server](https://github.com/user-attachments/assets/851f7e12-e876-4498-8b35-4893c512c59f)

3. Thêm server vào tab **Servers**

   ![Servers Tab](https://github.com/user-attachments/assets/822c5b2f-3b5c-4795-a4e9-640ff11d9823)

4. Chọn đúng **phiên bản Tomcat** vừa cài

   ![Tomcat Version](https://github.com/user-attachments/assets/9bc77614-8fea-452f-bda3-2b6715cac31f)

---

## 2. Cấu hình SQL Server

1. Đảm bảo đã bật:

   * ✅ **TCP/IP connection**
   * ✅ **SQL Server Authentication (tài khoản `sa`)**

   ⚠️ Nếu quên mật khẩu `sa` → liên hệ mình để hướng dẫn reset.

   ![SQL Config](https://github.com/user-attachments/assets/29789353-3735-4e92-9e32-4479255efcbb)

2. Sau khi thay đổi, **luôn restart SQL Server**.

---

## 3. Import Project vào Eclipse

1. Clone project về như thường.

2. Vào **Project Explorer** → chuột phải → **Gradle > Existing Gradle Project**

   ![Gradle Import](https://github.com/user-attachments/assets/50d3f73e-e6cc-4973-b27c-fb905391b8a9)

3. Chọn folder project đã clone → **Next > Next** (không chỉnh gì thêm).
   Sau khi load xong, xác nhận đúng project.

   ![Gradle Next](https://github.com/user-attachments/assets/5788b574-d176-4329-ad50-7b510beddaa6)

4. Cấu hình project:

   * Chuột phải **folder `app`** (không phải root project) → **Properties**

     ![Properties](https://github.com/user-attachments/assets/4ec26b9a-d8de-4752-8b0a-438a879c25ae)

   * Vào **Project Facets** → Tick:

     * ✅ **Dynamic Web Module 3.1**
     * ✅ **Java 17**

     ![Facets](https://github.com/user-attachments/assets/038171c0-7d6e-44a7-856e-e37a2d5cef8b)

   * Sửa **SQL connection string** nếu cần.

     ![SQL Conn](https://github.com/user-attachments/assets/2cbd950a-bd7e-4e60-8635-081576dc38ac)

---

## 4. Chạy Project trên Tomcat

1. Vào tab **Servers** → Thêm server mới

   ![Add Server](https://github.com/user-attachments/assets/1856956e-96f6-4a84-ae64-fe7734fa2a4c)

2. Chọn đúng Tomcat server đã cài

   ![Pick Server](https://github.com/user-attachments/assets/703bcba9-8733-4e06-9fbb-d631c7d48819)

3. Add project:

   * Chuột phải server → **Add and Remove...**
   * Nhấn **Add All** → **Finish**

   ![Add Project](https://github.com/user-attachments/assets/e073bd0a-c7b4-406b-8ba9-1934bebd0fcd)
   ![Finish](https://github.com/user-attachments/assets/77009577-6b6e-4700-8b8b-76c978ab08bc)

---

## 5. Fix lỗi Catalina Runtime (nếu gặp)

* Nếu chạy ngay sẽ báo lỗi như sau:

  ![Error](https://github.com/user-attachments/assets/22490e7f-1d52-4bc8-a476-c6ac19e91760)

### Cách xử lý:

1. Mở **Run > Run Configurations...**

   ![Run Config](https://github.com/user-attachments/assets/54aa179f-b8f0-489c-83f0-590e7791ae81)

2. Chọn server Tomcat đang cấu hình

   ![Select Server](https://github.com/user-attachments/assets/43bdd1bd-073b-4abd-aae9-e77059376cab)

3. Vào tab **Classpath** → Nhấn **Add External JARs...**
   → Trỏ đến thư mục cài Tomcat > **bin** → Thêm 2 file:

   * `bootstrap.jar`
   * `tomcat-juli.jar`
     👉 **Không thêm file khác**

   ![Add Jars](https://github.com/user-attachments/assets/69444b04-ab73-4e2f-aaad-370ab006ec21)
   ![Final Run](https://github.com/user-attachments/assets/dc243b32-d73f-4d06-8c5c-d79bd24bc448)

---

## 6. Kết quả

* Server chạy thành công → Truy cập:
  👉 [http://localhost:8080](http://localhost:8080)

  ![Run Ok](https://github.com/user-attachments/assets/8233d0d2-5f18-43aa-8b32-d8788f961d9a)
  ![Final](https://github.com/user-attachments/assets/9cca340c-9501-4f52-ab92-b93bf1f59afc)
