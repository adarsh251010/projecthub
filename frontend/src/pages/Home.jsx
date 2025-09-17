import { Typography, Box, Button } from '@mui/material'
import { Link } from 'react-router-dom'

export default function Home(){
  return (
    <Box>
      <Typography variant="h4" gutterBottom>Welcome to ProjectHub</Typography>
      <Typography variant="body1" gutterBottom>
        A personal portfolio + blogging platform built with React and Spring Boot.
      </Typography>
      <Button component={Link} to="/projects" variant="contained" sx={{mr:2}}>View Projects</Button>
      <Button component={Link} to="/blog" variant="outlined">Read Blog</Button>
    </Box>
  )
}
