# Section 2.1
# Bug Report - JPetStore Demo Application

## Bug List
| Bug ID | Title | Steps to Reproduce | Actual Result | Expected Result | Severity | Priority |
|------|------|------|------|------|------|------|
| BUG-001 | Duplicate validation message in search | 1. Open homepage <br> 2. Leave search field empty <br> 3. Click Search | Two identical error messages appear | Only one validation message should appear | Low | Low |
| BUG-002 | Registration form error | 1. Click Sign In <br> 2. Click Register Now <br> 3. Fill all fields <br> 4. Click Save Account Information | System returns error or account not created | Account should be created successfully | High | High |
| BUG-003 | Checkout allowed with out-of-stock product | 1. Select product marked Out of Stock <br> 2. Add to cart <br> 3. Open cart <br> 4. Click Proceed to Checkout | System allows checkout | Checkout should be blocked | High | High |
| BUG-004 | Cart accepts invalid quantity | 1. Add product to cart <br> 2. Change quantity to 0 or negative <br> 3. Click Update Cart | System accepts invalid quantity | Quantity should only allow positive numbers | Medium | Medium |
| BUG-005 | No logout confirmation message | 1. Login <br> 2. Click Sign Out | Redirect to homepage without confirmation | Logout confirmation message should appear | Low | Low |
| BUG-006 | Enter the Store CTA not visually prominent | 1. Open homepage <br> 2. Observe Enter the Store link | Appears only as simple text link | Should appear as prominent button | Low | Low |
| BUG-007 | Category navigation lacks visual emphasis | 1. Open catalog page <br> 2. Observe menu Fish, Dogs, Reptiles, Cats, Birds | Navigation appears as plain text with minimal styling | Navigation menu should have clearer styling and hover effect | Low | Low |
| BUG-008 | No active state for selected category | 1. Click Fish <br> 2. Click another category such as Dogs | No visual indicator showing current category | Active category should be highlighted | Low | Low |

## Summary
Total bugs reported: **8**

- High Severity: 2  
- Medium Severity: 1  
- Low Severity: 5

# Section 2.2
## Bug Lifecycle

After identifying the bugs in the **JPetStore Demo Application**, the issues should follow a standard bug lifecycle process to ensure they are properly handled and resolved.

### 1. New
The QA tester discovers and documents the bug during testing.  
Each bug is reported in a bug tracking system such as **Jira, or Bugzilla, etc**, including details like steps to reproduce, expected results, severity, and priority.

### 2. Assigned
The bug report is reviewed by the **QA Lead or Project Manager** and then assigned to the appropriate developer responsible for that module.

### 3. Open
The developer analyzes the bug and attempts to reproduce the issue in the development environment to understand the root cause.

### 4. Fixed
The developer fixes the issue in the codebase and commits the changes.

Examples from the bugs found:
- Fix duplicate validation messages in the search feature.
- Add validation to prevent checkout for out-of-stock products.
- Restrict cart quantity input to positive numbers.

### 5. Retest
After the fix is deployed to the testing environment, the QA tester retests the application using the same steps to verify that the bug has been resolved.

### 6. Verified
If the issue no longer occurs and the system behaves as expected, the bug is marked as **Verified**.

### 7. Closed
Once verification is completed successfully, the bug status is updated to **Closed**, indicating that the issue has been resolved.

### Possible Additional States
Sometimes bugs may move to other states such as:

- **Rejected** – The issue is not considered a bug.
- **Duplicate** – The issue has already been reported.
- **Deferred** – The fix is postponed to a future release.
- **Reopened** – The bug still exists after being marked as fixed.