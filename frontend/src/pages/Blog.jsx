import { useEffect, useState } from 'react'
import { List, ListItem, ListItemText, Typography } from '@mui/material'
import api from '../api'

export default function Blog(){
  const [posts, setPosts] = useState([])
  useEffect(() => { api.get('/public/posts').then(r=>setPosts(r.data)).catch(console.error) }, [])
  return (
    <>
      <Typography variant="h5" gutterBottom>Blog</Typography>
      <List>
        {posts.map(p => (
          <ListItem key={p.id}>
            <ListItemText primary={p.title} secondary={(p.content || '').slice(0,120)+'...'} />
          </ListItem>
        ))}
      </List>
    </>
  )
}
