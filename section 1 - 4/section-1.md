# JobStreet Indonesia – Registration Test Case Document

## 1. Overview

This document contains a collection of **test cases for the registration and login features** on the JobStreet Indonesia registration page.


---

## 2. Test Information

| Item | Description |
|---|---|
| Application Name | JobStreet Indonesia |
| Module | Registration & Authentication |
| Test Type | - |
| Platform | Web Application |
| Browser | - |
| Test Environment | - |
| Test Designer | Dian |
| Date Created | March 2026 |
| Document Version | 1.0 |
| Total Test Cases | 22 |

---

## 3. Scope of Testing

Testing covers the following areas:

- Initial view of the registration page
- Email input validation
- OTP code sending and verification
- Navigation links on the registration page
- Social authentication login (Google, Facebook, Apple)
- Error handling for network failures and invalid input
- Language consistency and UI display

---

## 4. Test Cases

| ID | Title | Description | Preconditions | Test Data | Steps | Expected Result | Actual Result | Status |
|---|---|---|---|---|---|---|---|---|
| JS-REG-001 | Registration page is displayed successfully | Check the initial registration page view to ensure all main components appear properly. | User is not logged in.<br>Browser can access internet. | {} | Open JobStreet registration page.<br>Observe UI components. | Logo, title, email field, social login buttons, help link, sign-in link, and legal footer are visible without layout issues. |  |  |
| JS-REG-002 | Employer link routes to recruiter area | Verify employer link directs users to recruiter page. | Registration page open | {} | Click **Are you looking for employees** link | User redirected to recruiter page successfully |  |  |
| JS-REG-003 | Sign in link routes user to login page | Ensure Sign in link opens login page | Registration page open | {} | Click **Sign in** link | Login page displayed successfully |  |  |
| JS-REG-004 | Help link accessible | Verify Help page can be opened | Registration page open | {} | Click **Help** link | Help page loads successfully |  |  |
| JS-REG-005 | Legal footer links functional | Ensure footer legal links open correct pages | Registration page open | {} | Click each legal link sequentially | Correct pages load without errors |  |  |
| JS-REG-006 | Request sign-in code with valid email | Verify new email can request OTP code | Registration page open | {"email":"jobseeker.indonesia@example.com"} | Enter email<br>Click send code | Success message shown and OTP sent |  |  |
| JS-REG-007 | Email spaces normalized | Ensure spaces around email are trimmed | Registration page open | {"email":" jobseeker.indonesia@example.com "} | Enter spaced email<br>Click send code | System trims spaces and processes valid email |  |  |
| JS-REG-008 | Empty email rejected | Ensure email cannot be empty | Registration page open | {"email":""} | Leave field empty<br>Click send code | Validation message appears |  |  |
| JS-REG-009 | Invalid email rejected | Ensure invalid format email rejected | Registration page open | {"email":"jobseeker.indonesia@"} | Enter invalid email<br>Click send code | Error message shown |  |  |
| JS-REG-010 | Registered email handled safely | Ensure registered email handled properly | Registered email available | {"email":"existing.user@example.com"} | Enter registered email<br>Send code | Safe system response without exposing data |  |  |
| JS-REG-011 | Enter key triggers submit | Ensure pressing Enter submits email | Registration page open | {"email":"jobseeker.indonesia@example.com"} | Enter email<br>Press Enter | Same action as clicking send code |  |  |
| JS-REG-012 | Network failure handled properly | Verify system behavior during network failure | Simulated network issue | {"email":"jobseeker.indonesia@example.com"} | Send code during network issue | Friendly error message shown |  |  |
| JS-REG-014 | Google authentication succeeds | Verify Google login flow | Google account available | {"provider":"Google"} | Click Google login<br>Authenticate | User successfully logged in |  |  |
| JS-REG-015 | Facebook authentication succeeds | Verify Facebook login flow | Facebook account available | {"provider":"Facebook"} | Click Facebook login<br>Authenticate | Login successful |  |  |
| JS-REG-016 | Apple authentication succeeds | Verify Apple login flow | Apple ID available | {"provider":"Apple"} | Click Apple login<br>Authenticate | Account created or login successful |  |  |
| JS-REG-017 | Cancelling social login handled properly | Ensure cancelling login does not break flow | Registration page open | {"provider":"Social"} | Click social login<br>Cancel authentication | Return to page normally |  |  |
| JS-REG-018 | Valid OTP accepted | Verify valid OTP works | OTP sent to email | {"otp":"Valid OTP"} | Enter OTP<br>Submit | Login or registration successful |  |  |
| JS-REG-019 | Invalid OTP rejected | Ensure incorrect OTP rejected | OTP page open | {"otp":"123456"} | Enter invalid code | Error message displayed |  |  |
| JS-REG-020 | Expired OTP rejected | Verify expired OTP behavior | Expired OTP available | {"otp":"Expired code"} | Enter expired OTP | Expired code error message |  |  |
| JS-REG-021 | Resend OTP generates new code | Verify resend code functionality | Verification page open | {} | Click resend<br>Enter new code | New code works successfully |  |  |
| JS-REG-023 | User redirected after successful registration | Verify post-registration flow | Registration completed | {} | Complete registration | User redirected to onboarding/dashboard |  |  |
| JS-REG-024 | Labels and validation messages readable | Verify clarity of labels and messages | Registration page open | {} | Observe UI text and validation messages | Text is clear and readable |  |  |
| JS-REG-025 | Page language consistent | Ensure page uses Bahasa Indonesia | Indonesian locale | {} | Review page text | All main text uses Bahasa Indonesia |  |  |

---

## 5. Result Summary

| Result Type | Count |
|---|---|
| Total Test Cases | 22 |
| Passed | - |
| Failed | - |
| Blocked | - |
| Not Executed | - |

- Actual Result and Status will be filled in after the **test execution** process is completed.

---
