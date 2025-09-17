import { useState } from 'react'
import { TextField, Button, Stack, Typography } from '@mui/material'
import { useNavigate } from 'react-router-dom'
import api from '../api'

export default function Login(){
  const nav = useNavigate()
  const [email, setEmail] = useState('admin@projecthub.dev')
  const [password, setPassword] = useState('admin123')
  const [error, setError] = useState('')

  const submit = async () => {
    setError('')
    try {
      const { data } = await api.post('/auth/login', { email, password })
      localStorage.setItem('token', data.token)
      nav('/admin')
    } catch (e) {
      setError('Invalid credentials')
    }
  }

  return (
    <Stack spacing={2} maxWidth={360}>
      <Typography variant="h5">Login</Typography>
      <TextField label="Email" value={email} onChange={e=>setEmail(e.target.value)} />
      <TextField label="Password" type="password" value={password} onChange={e=>setPassword(e.target.value)} />
      {error && <Typography color="error">{error}</Typography>}
      <Button variant="contained" onClick={submit}>Login</Button>
    </Stack>
  )
}
