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

     * ✅ app](http://localhost:8080/app)

  ![Run Ok](https://github.com/user-attachments/assets/8233d0d2-5f18-43aa-8b32-d8788f961d9a)
  ![Final](https://github.com/user-attachments/assets/9cca340c-9501-4f52-ab92-b93bf1f59afc)
