# QA Automation Questions

## 1. Explain what should and should not be automated and why?

### What Should Be Automated

**1. Regression Testing**  
Regression tests are executed repeatedly whenever there are code changes. Automating these tests ensures that previously working features continue to function correctly after updates.

**2. Repetitive Test Cases**  
Tests that require the same steps to be executed multiple times are ideal candidates for automation because automation reduces manual effort and human error.

**3. Smoke Tests / Build Verification Tests**  
Automation is useful for verifying that a new build is stable enough for further testing. These tests quickly check critical functionalities of the system.

**4. Data-Driven Tests**  
Tests that require multiple input combinations or datasets benefit from automation because they can be executed faster and more efficiently using automated scripts.

**5. API Testing**  
APIs are generally more stable and less dependent on UI changes. Automating API tests improves testing speed and reliability.

**Reason:**  
Automation improves efficiency, consistency, and execution speed, especially for tests that are executed frequently.

---

### What Should Not Be Automated

**1. Exploratory Testing**  
Exploratory testing relies heavily on human creativity, intuition, and experience. Therefore, it is better suited for manual testing.

**2. Usability Testing**  
User experience evaluation requires human judgment and observation, which automation tools cannot accurately assess.

**3. Tests That Are Rarely Executed**  
If a test case is executed only once or very infrequently, the effort required to automate it may not be justified.

**4. Features That Frequently Change**  
If a feature or UI element is still unstable or frequently modified, automation scripts will require constant maintenance and may become inefficient.

**Reason:**  
Automation requires time for development and maintenance, so it should be applied where it provides long-term value.

---

## 2. How do you decide whether a failed automation test is a real bug or a flaky test?

**1. Re-run the Failed Test**  
If the test passes in subsequent executions without any code changes, the failure may indicate a flaky test.

**2. Check Logs and Error Messages**  
Reviewing logs and error messages helps identify whether the issue is related to the application or the automation script.

**3. Review Recent Code Changes**  
If there were recent changes to the application code or UI related to the test scenario, the failure may represent a real defect.

**4. Verify Test Environment Stability**  
Issues such as network instability, service downtime, or timeout errors can cause flaky tests.

**5. Execute the Test Manually**  
Performing the same test steps manually can help confirm whether the problem exists in the application itself.

---

## 3. If an automation test fails, what steps should you take?

**1. Analyze the Test Results and Logs**  
Review logs, screenshots, and error messages to understand the root cause of the failure.

**2. Re-run the Test**  
Execute the test again to determine whether the failure is consistent or intermittent.

**3. Perform Manual Verification**  
Run the same scenario manually to verify whether the issue exists in the application.

**4. Identify the Root Cause**  
Determine whether the failure is caused by:
- An application bug  
- An issue in the automation script  
- An unstable testing environment  

**5. Discuss the Issue with the Development Team**  
If the issue appears to be related to the application behavior, the QA engineer should discuss the findings with the developer responsible for the feature to review the behavior together.

**6. Clarify Requirements with BA or PM (if needed)**  
If the developer does not agree that the behavior is a bug, the issue should be reviewed together with the Business Analyst (BA) or Product Manager (PM) to confirm the expected behavior according to the product requirements.

**7. Report a Bug if Necessary**  
If the issue is confirmed to be an application defect, create a clear bug report including reproduction steps, expected results, and actual results.

**8. Fix or Improve the Automation Script**  
If the failure is caused by an unstable automation script, update the script to improve reliability.