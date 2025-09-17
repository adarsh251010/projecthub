import { useEffect, useState } from 'react'
import { Grid, Card, CardContent, Typography, CardActions, Button } from '@mui/material'
import api from '../api'

export default function Projects(){
  const [items, setItems] = useState([])
  useEffect(() => {
    api.get('/public/projects').then(res => setItems(res.data)).catch(console.error)
  }, [])
  return (
    <Grid container spacing={2}>
      {items.map(p => (
        <Grid item xs={12} md={6} key={p.id}>
          <Card>
            <CardContent>
              <Typography variant="h6">{p.title}</Typography>
              <Typography variant="body2">{p.description}</Typography>
            </CardContent>
            <CardActions>
              {p.githubUrl && <Button href={p.githubUrl} target="_blank">GitHub</Button>}
              {p.liveUrl && <Button href={p.liveUrl} target="_blank">Live</Button>}
            </CardActions>
          </Card>
        </Grid>
      ))}
    </Grid>
  )
}
