
import { useState } from "react";
import {
  Box,
  Typography,
  TextField,
  Button,
  Avatar,
  Container,
  Stack,
  Divider,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { motion } from "framer-motion";
import axios from "../api/axiosConfig";
import { useAuth } from "../auth/AuthContext";
import PersonIcon from '@mui/icons-material/Person';
import EmailIcon from '@mui/icons-material/Email';
import LockIcon from '@mui/icons-material/Lock';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import AddAPhotoIcon from '@mui/icons-material/AddAPhoto';
import GoogleIcon from '@mui/icons-material/Google';

export default function SignUp() {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    password: "",
  });
  
  const [profileImage, setProfileImage] = useState(null);
  const [preview, setPreview] = useState(null);

  const { fullName, email, password } = formData;
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleChange = (e) =>
    setFormData({ ...formData, [e.target.name]: e.target.value });

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      setProfileImage(file);
      setPreview(URL.createObjectURL(file));
    }
  };

  const handleSubmit = async () => {
    if (!fullName || !email || !password) {
      toast.error("Please fill in all fields");
      return;
    }

    try {
      const formDataToSend = new FormData();
      formDataToSend.append("username", fullName);
      formDataToSend.append("email", email);
      formDataToSend.append("password", password);
      
      if (profileImage) {
        formDataToSend.append("file", profileImage);
      }

      const res = await axios.post("/auth/signup-with-image", formDataToSend);
      login(res.data.token);
      toast.success("Account created!");
      navigate("/");
    } catch (err) {
      toast.error(err.response?.data?.message || "Sign up failed");
    }
  };

  return (
    <Box 
      sx={{ 
        minHeight: "100vh", 
        display: "flex", 
        background: "linear-gradient(to right, #f0f8ff, #ffffff)",
        fontFamily: "'Inter', 'Poppins', sans-serif"
      }}
    >
      {/* LEFT PANEL */}
      <Box
        sx={{
          width: { xs: "100%", md: "50%" },
          display: { xs: "none", md: "flex" },
          position: "relative",
          overflow: "hidden",
          background: "linear-gradient(135deg,rgb(31, 223, 60) 0%,rgb(51, 255, 197) 100%)",
          color: "white",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        {/* Abstract design elements */}
        <Box
          sx={{
            position: "absolute",
            width: "500px",
            height: "500px",
            borderRadius: "38% 62% 63% 37% / 41% 44% 56% 59%",
            background: "rgba(255,255,255,0.1)",
            top: "-100px",
            left: "-100px",
            animation: "move 20s infinite alternate",
            "@keyframes move": {
              "0%": { transform: "translate(0, 0) rotate(0deg)" },
              "100%": { transform: "translate(50px, 50px) rotate(10deg)" }
            }
          }}
        />
        <Box
          sx={{
            position: "absolute",
            width: "400px",
            height: "400px",
            borderRadius: "46% 54% 39% 61% / 44% 57% 43% 56%",
            background: "rgba(255,255,255,0.1)",
            bottom: "-50px",
            right: "-100px",
            animation: "move2 18s infinite alternate",
            "@keyframes move2": {
              "0%": { transform: "translate(0, 0) rotate(0deg)" },
              "100%": { transform: "translate(-30px, -30px) rotate(-5deg)" }
            }
          }}
        />

        <motion.div
          initial={{ opacity: 0, y: 30 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 0.8 }}
          style={{ position: "relative", zIndex: 2, maxWidth: "450px", padding: "0 40px" }}
        >
          <Typography variant="h2" fontWeight="800" mb={3} sx={{ fontSize: { xs: '2rem', md: '3rem' } }}>
            Welcome to LearnSpark! 👋
          </Typography>
          <Typography variant="body1" mb={5} sx={{ opacity: 0.9, fontSize: "1.15rem", lineHeight: 1.6 }}>
            Join our community and discover all the amazing features waiting for you.
          </Typography>
          <Button
            variant="outlined"
            startIcon={<ArrowForwardIcon />}
            sx={{
              color: "white",
              borderColor: "rgba(255,255,255,0.6)",
              borderWidth: "1.5px",
              px: 4,
              py: 1.5,
              borderRadius: "12px",
              fontWeight: "600",
              textTransform: "none",
              fontSize: "1rem",
              backdropFilter: "blur(10px)",
              backgroundColor: "rgba(255,255,255,0.1)",
              transition: "all 0.3s ease",
              "&:hover": {
                backgroundColor: "rgba(255,255,255,0.2)",
                borderColor: "white",
                transform: "translateY(-2px)",
              },
            }}
            onClick={() => navigate("/signin")}
          >
            Sign In
          </Button>
        </motion.div>
      </Box>

      {/* RIGHT PANEL */}
      <Container 
        maxWidth="sm" 
        sx={{ 
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          px: { xs: 2, sm: 4, md: 6 },
          py: 5,
          width: { xs: "100%", md: "50%" }
        }}
      >
        <motion.div
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.3, duration: 0.6 }}
          style={{ width: "100%" }}
        >
          <Box sx={{ mb: 6, textAlign: "center" }}>
            <Typography 
              variant="h3" 
              fontWeight="700" 
              sx={{ 
                fontSize: { xs: '1.8rem', sm: '2.2rem' },
                color: "#00d982",
                mb: 1.5
              }}
            >
              Create Account
            </Typography>
            <Typography 
              variant="body1"
              sx={{ 
                color: "#64748B",
                fontSize: "1rem"
              }}
            >
              Join LearnSpark and start your journey today
            </Typography>
          </Box>

          {/* Avatar Preview + Upload */}
          <Box sx={{ display: 'flex', justifyContent: 'center', mb: 4 }}>
            <Box
              sx={{
                position: 'relative',
                width: 100,
                height: 100,
              }}
            >
              <Avatar
                src={preview}
                sx={{ 
                  width: 100, 
                  height: 100,
                  boxShadow: "0 4px 14px rgba(0, 87, 217, 0.15)",
                  border: "3px solid #fff",
                }}
              />
              <Button
                component="label"
                variant="contained"
                sx={{
                  position: 'absolute',
                  bottom: -5,
                  right: -5,
                  minWidth: 'unset',
                  width: 36,
                  height: 36,
                  borderRadius: '50%',
                  backgroundColor: "#0057D9",
                  boxShadow: "0 4px 10px rgba(0, 87, 217, 0.25)",
                  "&:hover": {
                    backgroundColor: "#004FC3",
                  }
                }}
              >
                <AddAPhotoIcon fontSize="small" />
                <input hidden type="file" accept="image/*" onChange={handleImageChange} />
              </Button>
            </Box>
          </Box>

          <Stack spacing={3}>
            <TextField
              fullWidth
              label="Full Name"
              name="fullName"
              variant="outlined"
              InputProps={{
                startAdornment: <PersonIcon sx={{ mr: 1, color: "#94A3B8" }} />,
              }}
              value={fullName}
              onChange={handleChange}
              sx={{
                "& .MuiOutlinedInput-root": {
                  borderRadius: "12px",
                  backgroundColor: "#F9FAFB",
                  "&:hover fieldset": {
                    borderColor: "#CBD5E1",
                  },
                  "&.Mui-focused fieldset": {
                    borderColor: "#0057D9",
                  },
                },
                "& .MuiInputLabel-root.Mui-focused": {
                  color: "#0057D9",
                },
              }}
            />
            
            <TextField
              fullWidth
              label="Email Address"
              name="email"
              variant="outlined"
              InputProps={{
                startAdornment: <EmailIcon sx={{ mr: 1, color: "#94A3B8" }} />,
              }}
              value={email}
              onChange={handleChange}
              sx={{
                "& .MuiOutlinedInput-root": {
                  borderRadius: "12px",
                  backgroundColor: "#F9FAFB",
                  "&:hover fieldset": {
                    borderColor: "#CBD5E1",
                  },
                  "&.Mui-focused fieldset": {
                    borderColor: "#0057D9",
                  },
                },
                "& .MuiInputLabel-root.Mui-focused": {
                  color: "#0057D9",
                },
              }}
            />
            
            <TextField
              fullWidth
              label="Password"
              name="password"
              type="password"
              variant="outlined"
              InputProps={{
                startAdornment: <LockIcon sx={{ mr: 1, color: "#94A3B8" }} />,
              }}
              value={password}
              onChange={handleChange}
              sx={{
                "& .MuiOutlinedInput-root": {
                  borderRadius: "12px",
                  backgroundColor: "#F9FAFB",
                  "&:hover fieldset": {
                    borderColor: "#CBD5E1",
                  },
                  "&.Mui-focused fieldset": {
                    borderColor: "#0057D9",
                  },
                },
                "& .MuiInputLabel-root.Mui-focused": {
                  color: "#0057D9",
                },
              }}
            />

            <Button
              fullWidth
              variant="contained"
              sx={{
                mt: 2,
                py: 1.8,
                background: "linear-gradient(135deg,rgb(31, 223, 60) 0%,rgb(51, 255, 197) 100%)",
                fontWeight: "600",
                borderRadius: "12px",
                textTransform: "none",
                fontSize: "1rem",
                letterSpacing: 0.5,
                boxShadow: "0 10px 15px rgba(0, 87, 217, 0.2)",
                transition: "all 0.3s ease",
                "&:hover": {
                  background: "linear-gradient(135deg,rgb(31, 223, 60) 0%,rgb(51, 255, 197) 100%)",
                  boxShadow: "0 10px 25px rgba(0, 87, 217, 0.3)",
                  transform: "translateY(-2px)",
                },
              }}
              onClick={handleSubmit}
            >
              Create Account
            </Button>
          </Stack>

          <Box sx={{ my: 4, display: "flex", alignItems: "center" }}>
            <Divider sx={{ flexGrow: 1 }} />
            <Typography variant="body2" sx={{ px: 2, color: "#64748B" }}>OR</Typography>
            <Divider sx={{ flexGrow: 1 }} />
          </Box>

          <Button
            fullWidth
            variant="outlined"
            startIcon={<GoogleIcon />}
            sx={{
              py: 1.8,
              borderColor: "#E2E8F0",
              borderWidth: "1.5px",
              color: "#0F172A",
              backgroundColor: "#FFFFFF",
              fontWeight: 500,
              borderRadius: "12px",
              textTransform: "none",
              fontSize: "1rem",
              transition: "all 0.2s ease",
              "&:hover": {
                borderColor: "#CBD5E1",
                backgroundColor: "#F8FAFC",
                boxShadow: "0 2px 10px rgba(15, 23, 42, 0.08)",
              },
            }}
          >
            Sign up with Google
          </Button>

          <Typography
            variant="body2"
            align="center"
            mt={4}
            sx={{ color: "#64748B" }}
          >
            Already have an account?{" "}
            <Typography
              component="span"
              sx={{
                color: "#00d982",
                fontWeight: 600,
                cursor: "pointer",
                "&:hover": {
                  textDecoration: "underline",
                },
              }}
              onClick={() => navigate("/signin")}
            >
              Sign in
            </Typography>
          </Typography>
        </motion.div>
      </Container>
    </Box>
  );
}