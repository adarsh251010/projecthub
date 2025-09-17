import { useEffect, useState } from 'react'
import { Typography, TextField, Button, Stack, Divider } from '@mui/material'
import api from '../api'

export default function Admin(){
  const [projects, setProjects] = useState([])
  const [form, setForm] = useState({ title: '', description: '' })

  const load = () => api.get('/public/projects').then(r=>setProjects(r.data))
  useEffect(() => { load() }, [])

  const save = async () => {
    await api.post('/projects', form)
    setForm({ title:'', description:'' })
    load()
  }

  return (
    <Stack spacing={2}>
      <Typography variant="h5">Admin Dashboard</Typography>
      <Typography variant="subtitle1">Create Project</Typography>
      <TextField label="Title" value={form.title} onChange={e=>setForm({...form, title:e.target.value})} />
      <TextField label="Description" multiline rows={3} value={form.description} onChange={e=>setForm({...form, description:e.target.value})} />
      <Button variant="contained" onClick={save}>Save</Button>
      <Divider sx={{my:2}}/>
      <Typography variant="subtitle1">Existing Projects ({projects.length})</Typography>
      {projects.map(p => (<div key={p.id}><b>{p.title}</b> — {p.description}</div>))}
    </Stack>
  )
}
