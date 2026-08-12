/**
 * ============================================================
 *  CYBER SECURITY DEFENSIVE FRAMEWORK
 *  Industrial Internship Project
 * ------------------------------------------------------------
 *  Intern      : Rohit Swami
 *  Email       : rohitswami771@gmail.com
 *  GitHub      : https://github.com/Rohitswami23
 *  Domain      : Cyber Security
 *  Provider    : UniConverge Technologies Pvt Ltd (UCT)
 *               & upSkill Campus
 *  Duration    : 6 Weeks | 2026
 * ============================================================
 *
 *  PROJECT DESCRIPTION:
 *  This program demonstrates a conceptual Cyber Security
 *  Defensive Framework covering the major attack vectors
 *  studied during the internship and their corresponding
 *  defensive controls.
 *
 *  Topics Covered:
 *   - CIA Triad (Confidentiality, Integrity, Availability)
 *   - Social Engineering Detection
 *   - DDoS Attack Simulation & Mitigation
 *   - Two-Factor Authentication (2FA) Simulation
 *   - Sensitive Data Exposure (SDE) Checker
 *   - Broken Access Control (BAC) Validator
 *   - OWASP Top 10 Reference
 *   - Layered Defensive Control Framework
 * ============================================================
 */

import java.util.*;

public class CyberSecurityDefensiveFramework_Rohit_USC_UCT {

    // ─────────────────────────────────────────────────────────
    //  CONSTANTS & CONFIGURATION
    // ─────────────────────────────────────────────────────────

    static final String INTERN_NAME    = "Rohit Swami";
    static final String DOMAIN         = "Cyber Security";
    static final String PROVIDER       = "UniConverge Technologies Pvt Ltd (UCT) & upSkill Campus";
    static final String GITHUB         = "https://github.com/Rohitswami23/upskillCampus";

    // Simulated user database: username -> {password, role, 2fa_code}
    static final Map<String, String[]> USER_DB = new HashMap<>();
    static {
        USER_DB.put("rohit",   new String[]{"pass@123", "ADMIN",  "847291"});
        USER_DB.put("intern1", new String[]{"intern1!", "USER",   "392847"});
        USER_DB.put("guest",   new String[]{"guest123", "VIEWER", "192837"});
    }

    // Common phishing/social engineering keywords
    static final List<String> PHISHING_KEYWORDS = Arrays.asList(
        "urgent", "verify your account", "click here immediately",
        "your account will be suspended", "confirm your password",
        "limited time offer", "you have won", "act now",
        "bank details required", "otp", "share your credentials"
    );

    // OWASP Top 10 (2021)
    static final String[][] OWASP_TOP_10 = {
        {"A01:2021", "Broken Access Control",             "HIGH"},
        {"A02:2021", "Cryptographic Failures (SDE)",      "HIGH"},
        {"A03:2021", "Injection",                         "HIGH"},
        {"A04:2021", "Insecure Design",                   "MEDIUM"},
        {"A05:2021", "Security Misconfiguration",         "MEDIUM"},
        {"A06:2021", "Vulnerable & Outdated Components",  "MEDIUM"},
        {"A07:2021", "Identification & Authentication",   "HIGH"},
        {"A08:2021", "Software & Data Integrity Failures","MEDIUM"},
        {"A09:2021", "Security Logging & Monitoring",     "LOW"},
        {"A10:2021", "Server-Side Request Forgery (SSRF)","MEDIUM"},
    };

    // Layered Defense Framework
    static final String[][] DEFENSE_LAYERS = {
        {"Layer 1", "Identity & Access Control", "RBAC, 2FA, Session Invalidation, No Client-Side Trust"},
        {"Layer 2", "Data Protection",           "TLS/SSL, AES-256, bcrypt/Argon2, Data Minimization"},
        {"Layer 3", "Network Security",          "Firewall, IDS/IPS, VPN, Network Segmentation"},
        {"Layer 4", "API Security",              "OAuth 2.0, JWT Tokens, Rate Limiting, API Gateway"},
        {"Layer 5", "Human Security",            "Awareness Training, Phishing Simulation, Policies"},
        {"Layer 6", "Monitoring & Response",     "SIEM, Audit Logs, Incident Response Plan"},
    };

    // ─────────────────────────────────────────────────────────
    //  MAIN METHOD
    // ─────────────────────────────────────────────────────────

    public static void main(String[] args) {
        printBanner();

        System.out.println("\n========== RUNNING CYBER SECURITY FRAMEWORK DEMO ==========\n");

        // Module 1: CIA Triad
        demonstrateCIATriad();

        // Module 2: Social Engineering Detector
        demonstrateSocialEngineeringDetector();

        // Module 3: 2FA Authentication Simulation
        demonstrate2FA();

        // Module 4: Sensitive Data Exposure (SDE) Checker
        demonstrateSDEChecker();

        // Module 5: Broken Access Control (BAC) Validator
        demonstrateBACValidator();

        // Module 6: DDoS Simulation & Mitigation
        demonstrateDDoSSimulation();

        // Module 7: OWASP Top 10 Reference
        printOWASPTop10();

        // Module 8: Layered Defense Framework
        printDefenseFramework();

        printFooter();
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 1: CIA TRIAD
    // ─────────────────────────────────────────────────────────

    static void demonstrateCIATriad() {
        printSectionHeader("MODULE 1 — CIA Triad (Foundation of Cyber Security)");

        String[][] cia = {
            {"CONFIDENTIALITY",
             "Ensures that sensitive information is accessible ONLY to authorized individuals.",
             "Encryption (AES-256), Access Control, VPN, Data Classification"},
            {"INTEGRITY",
             "Ensures data is accurate, complete, and has NOT been tampered with.",
             "Hash Functions (SHA-256), Digital Signatures, Checksums, Audit Logs"},
            {"AVAILABILITY",
             "Ensures systems and data are accessible when needed by authorized users.",
             "Redundancy, Load Balancing, DDoS Protection, Disaster Recovery"},
        };

        for (String[] item : cia) {
            System.out.println("  ► " + item[0]);
            System.out.println("    Definition : " + item[1]);
            System.out.println("    Controls   : " + item[2]);
            System.out.println();
        }
        System.out.println("  ✔  CIA Triad check PASSED — All three pillars defined.\n");
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 2: SOCIAL ENGINEERING DETECTOR
    // ─────────────────────────────────────────────────────────

    static void demonstrateSocialEngineeringDetector() {
        printSectionHeader("MODULE 2 — Social Engineering / Phishing Detector");

        String[] testMessages = {
            "Hello Rohit, please verify your account immediately or it will be suspended.",
            "Team meeting scheduled for Monday at 10am. Please confirm attendance.",
            "URGENT: Click here immediately to confirm your bank details required.",
            "Your project report has been reviewed. Good work this week!",
            "You have won a prize! Act now and share your credentials to claim.",
        };

        System.out.println("  Scanning messages for phishing/social engineering indicators...\n");

        for (String msg : testMessages) {
            boolean isSuspicious = isSocialEngineeringAttempt(msg);
            String status = isSuspicious ? "⚠  SUSPICIOUS  — POSSIBLE PHISHING ATTEMPT"
                                         : "✔  SAFE        — No threat indicators found";
            System.out.println("  Message  : \"" + msg + "\"");
            System.out.println("  Result   : " + status);
            System.out.println();
        }
    }

    static boolean isSocialEngineeringAttempt(String message) {
        String lower = message.toLowerCase();
        for (String keyword : PHISHING_KEYWORDS) {
            if (lower.contains(keyword)) return true;
        }
        return false;
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 3: TWO-FACTOR AUTHENTICATION (2FA) SIMULATION
    // ─────────────────────────────────────────────────────────

    static void demonstrate2FA() {
        printSectionHeader("MODULE 3 — Two-Factor Authentication (2FA) Simulation");

        System.out.println("  Simulating login attempts with 2FA validation...\n");

        // Test cases: {username, password, otp_entered, shouldPass}
        String[][] testLogins = {
            {"rohit",   "pass@123", "847291", "VALID"},
            {"rohit",   "pass@123", "000000", "WRONG OTP"},
            {"intern1", "wrongpwd", "392847", "WRONG PASSWORD"},
            {"hacker",  "hack123",  "111111", "USER NOT FOUND"},
            {"guest",   "guest123", "192837", "VALID"},
        };

        for (String[] test : testLogins) {
            String username = test[0], password = test[1], otp = test[2];
            String result = authenticateWith2FA(username, password, otp);
            System.out.println("  User: " + username + " | Password: " + password
                             + " | OTP: " + otp);
            System.out.println("  Auth Result: " + result);
            System.out.println();
        }

        System.out.println("  KEY LESSON: Even if password is stolen, 2FA blocks unauthorized access.\n");
    }

    static String authenticateWith2FA(String username, String password, String otp) {
        if (!USER_DB.containsKey(username))
            return "✘  ACCESS DENIED — User not found";

        String[] creds = USER_DB.get(username);
        if (!creds[0].equals(password))
            return "✘  ACCESS DENIED — Incorrect password (Factor 1 failed)";

        if (!creds[2].equals(otp))
            return "✘  ACCESS DENIED — Invalid OTP (Factor 2 failed)";

        return "✔  ACCESS GRANTED — Welcome, " + username + "! Role: " + creds[1];
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 4: SENSITIVE DATA EXPOSURE (SDE) CHECKER
    // ─────────────────────────────────────────────────────────

    static void demonstrateSDEChecker() {
        printSectionHeader("MODULE 4 — Sensitive Data Exposure (SDE) Checker");

        System.out.println("  Checking API responses for sensitive data exposure...\n");

        // Simulated API responses (some safe, some exposing sensitive data)
        String[][] apiResponses = {
            {"GET /api/user/profile",
             "{\"name\":\"Rohit\",\"email\":\"rohit@email.com\",\"password\":\"pass@123\",\"creditCard\":\"4111-1111-1111-1111\"}",
             "EXPOSED"},
            {"GET /api/user/profile (fixed)",
             "{\"name\":\"Rohit\",\"email\":\"rohit@email.com\"}",
             "SAFE"},
            {"GET /api/transactions",
             "{\"txn_id\":\"T001\",\"amount\":5000,\"ssn\":\"123-45-6789\",\"api_key\":\"sk_live_abc123\"}",
             "EXPOSED"},
            {"GET /api/transactions (fixed)",
             "{\"txn_id\":\"T001\",\"amount\":5000,\"status\":\"success\"}",
             "SAFE"},
        };

        List<String> sensitiveFields = Arrays.asList(
            "password", "creditcard", "ssn", "api_key", "secret",
            "token", "private_key", "cvv", "pin"
        );

        for (String[] api : apiResponses) {
            String endpoint = api[0], response = api[1];
            String lower = response.toLowerCase();
            List<String> found = new ArrayList<>();
            for (String field : sensitiveFields) {
                if (lower.contains(field)) found.add(field.toUpperCase());
            }
            boolean exposed = !found.isEmpty();
            System.out.println("  Endpoint  : " + endpoint);
            if (exposed) {
                System.out.println("  Status    : ⚠  SDE DETECTED — Exposed fields: " + found);
                System.out.println("  Fix       : Strip sensitive fields before sending API response.");
            } else {
                System.out.println("  Status    : ✔  SAFE — No sensitive fields detected in response.");
            }
            System.out.println();
        }
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 5: BROKEN ACCESS CONTROL (BAC) VALIDATOR
    // ─────────────────────────────────────────────────────────

    static void demonstrateBACValidator() {
        printSectionHeader("MODULE 5 — Broken Access Control (BAC) Validator");

        System.out.println("  Testing access control enforcement...\n");

        // {username, requestedResource, requiredRole, result}
        String[][] accessTests = {
            {"rohit",   "/admin/dashboard",    "ADMIN",  "GRANT"},
            {"intern1", "/admin/dashboard",    "ADMIN",  "DENY"},
            {"intern1", "/user/profile",       "USER",   "GRANT"},
            {"guest",   "/user/profile",       "USER",   "DENY"},
            {"guest",   "/public/home",        "VIEWER", "GRANT"},
            // Simulating BAC exploit attempt
            {"intern1", "/admin/deleteUser",   "ADMIN",  "DENY"},
            {"guest",   "/api/admin?role=admin","ADMIN", "DENY"},
        };

        for (String[] test : accessTests) {
            String username = test[0], resource = test[1], required = test[2];
            String[] creds = USER_DB.get(username);
            boolean hasAccess = false;

            if (creds != null) {
                String userRole = creds[1];
                if (required.equals("VIEWER")) hasAccess = true;
                else if (required.equals("USER") && (userRole.equals("USER") || userRole.equals("ADMIN")))
                    hasAccess = true;
                else if (required.equals("ADMIN") && userRole.equals("ADMIN"))
                    hasAccess = true;
            }

            String status = hasAccess
                ? "✔  ACCESS GRANTED (server-side RBAC check passed)"
                : "✘  ACCESS DENIED  (BAC enforced — insufficient privileges)";

            System.out.println("  User: " + username + " → Resource: " + resource);
            System.out.println("  " + status);
            System.out.println();
        }

        System.out.println("  KEY LESSON: ALL access decisions enforced SERVER-SIDE only.");
        System.out.println("              Client parameters (cookies/URLs) are NEVER trusted.\n");
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 6: DDoS SIMULATION & MITIGATION
    // ─────────────────────────────────────────────────────────

    static void demonstrateDDoSSimulation() {
        printSectionHeader("MODULE 6 — DDoS Attack Simulation & Rate Limiting");

        System.out.println("  Simulating incoming requests to server...\n");

        int RATE_LIMIT        = 5;   // max requests per IP per window
        int BLOCK_THRESHOLD   = 8;   // block IP after this many requests
        Map<String, Integer> requestCount = new HashMap<>();

        // Simulated incoming requests: {ip, requestNum}
        String[] requestIPs = {
            "192.168.1.10", "192.168.1.10", "10.0.0.5",
            "192.168.1.10", "10.0.0.5",     "192.168.1.10",
            "172.16.0.3",   "192.168.1.10", "192.168.1.10",
            "192.168.1.10", "192.168.1.10", "10.0.0.5",
        };

        for (String ip : requestIPs) {
            requestCount.put(ip, requestCount.getOrDefault(ip, 0) + 1);
            int count = requestCount.get(ip);
            String status;

            if (count > BLOCK_THRESHOLD)
                status = "🚫 IP BLOCKED   — DDoS pattern detected. Firewall rule applied.";
            else if (count > RATE_LIMIT)
                status = "⚠  RATE LIMITED — Too many requests. Throttling applied.";
            else
                status = "✔  REQUEST OK   — Within normal threshold.";

            System.out.println("  IP: " + ip + " | Request #" + count + " → " + status);
        }

        System.out.println("\n  KEY LESSON: Rate limiting and IP blocking are first-line DDoS defenses.\n");
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 7: OWASP TOP 10 REFERENCE
    // ─────────────────────────────────────────────────────────

    static void printOWASPTop10() {
        printSectionHeader("MODULE 7 — OWASP Top 10 (2021) Reference");

        System.out.printf("  %-12s %-42s %-8s%n", "Code", "Vulnerability", "Risk");
        System.out.println("  " + "─".repeat(65));
        for (String[] entry : OWASP_TOP_10) {
            System.out.printf("  %-12s %-42s %-8s%n", entry[0], entry[1], entry[2]);
        }
        System.out.println();
    }

    // ─────────────────────────────────────────────────────────
    //  MODULE 8: LAYERED DEFENSE FRAMEWORK
    // ─────────────────────────────────────────────────────────

    static void printDefenseFramework() {
        printSectionHeader("MODULE 8 — Layered Defensive Control Framework");

        System.out.println("  Defense-in-Depth Model — 6 Security Layers:\n");
        for (String[] layer : DEFENSE_LAYERS) {
            System.out.println("  ► " + layer[0] + " — " + layer[1]);
            System.out.println("    Controls: " + layer[2]);
            System.out.println();
        }
        System.out.println("  KEY INSIGHT: No single layer is sufficient. Overlapping controls");
        System.out.println("               compensate when any individual layer is bypassed.\n");
    }

    // ─────────────────────────────────────────────────────────
    //  UTILITY METHODS
    // ─────────────────────────────────────────────────────────

    static void printBanner() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║        CYBER SECURITY DEFENSIVE FRAMEWORK                    ║");
        System.out.println("║        Industrial Internship Project — 2026                  ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Intern  : " + padRight(INTERN_NAME, 51) + "║");
        System.out.println("║  Domain  : " + padRight(DOMAIN, 51)      + "║");
        System.out.println("║  GitHub  : " + padRight(GITHUB, 51)      + "║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    static void printSectionHeader(String title) {
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│  " + padRight(title, 61) + "│");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
    }

    static void printFooter() {
        System.out.println("═".repeat(65));
        System.out.println("  ALL MODULES COMPLETED SUCCESSFULLY");
        System.out.println("  Intern   : " + INTERN_NAME);
        System.out.println("  Provider : " + PROVIDER);
        System.out.println("  GitHub   : " + GITHUB);
        System.out.println("═".repeat(65));
    }

    static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
